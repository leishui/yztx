package com.example.yztx.utils;

import com.example.yztx.constant.Paths;
import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Resource;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.ResourceService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;

public class FileUtils {
    /**
     * 创建或重命名文件
     * ps：sss.jpg    sss(1).jpg
     */
    public static File createOrRenameFile(File from, String toPrefix, String toSuffix) {
        File directory = from.getParentFile();
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Created directory " + directory.getAbsolutePath());
            }
        }
        File newFile = new File(directory, toPrefix + toSuffix);
        for (int i = 1; newFile.exists() && i < Integer.MAX_VALUE; i++) {
            newFile = new File(directory, toPrefix + "(" + i + ")" + toSuffix);
        }
        if (!from.renameTo(newFile)) {
            System.out.println("Couldn't rename file to " + newFile.getAbsolutePath());
            return from;

        }
        return newFile;
    }

    /**
     * 获取File的 . 前后字串
     */
    public static String[] getFileInfo(File from) {
        String fileName = from.getName();
        int index = fileName.lastIndexOf(".");
        String toPrefix = "";
        String toSuffix = "";
        if (index == -1) {
            toPrefix = fileName;
        } else {
            toPrefix = fileName.substring(0, index);
            toSuffix = fileName.substring(index, fileName.length());
        }
        return new String[]{toPrefix, toSuffix};
    }

    /**
     * 获取文件
     *
     * @param id       上传者id
     * @param name     文件名
     * @param response 不用管
     */
    public static void getFile(String id, String name, HttpServletResponse response) {
        File file = new File(Paths.DATA_PATH + id + "/" + name);
        try (
                InputStream in = new FileInputStream(file);
                ServletOutputStream out = response.getOutputStream()) {
            int length;
            byte[] buffer = new byte[4 * 1024];
            // 向前台输出视频流
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("文件读取失败, 文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //上传文件
    public static SimpleMsg uploadFile(MultipartFile file, Long up_id, ResourceService resourceService) {
        SimpleMsg msg = new SimpleMsg();
        Resource resource = new Resource();
        if (file.isEmpty()) {
            msg.setStatus(StatusType.FAILED);
            msg.setMsg("上传文件为空");
            return msg;
        }
        try {
            File tmp = new File(Paths.DATA_PATH + up_id, Objects.requireNonNull(file.getOriginalFilename()));
            if (!tmp.getParentFile().exists()) {
                if (!tmp.getParentFile().mkdirs()) return new SimpleMsg(StatusType.FAILED, "创建目录失败");
            }
            String[] fileInfo = FileUtils.getFileInfo(tmp);
            File orRenameFile = FileUtils.createOrRenameFile(tmp, fileInfo[0], fileInfo[1]);
            if (tmp.renameTo(orRenameFile)) {
                file.transferTo(orRenameFile);
            } else {
                file.transferTo(tmp);
            }
            resource.up_id = up_id;
            resource.url = orRenameFile.getName();
            return resourceService.save(resource);
        } catch (IOException e) {
            msg.setStatus(StatusType.FAILED);
            msg.setContent("上传失败，io异常");
        }
        return msg;
    }

    public static void getFile(File downloadFile, HttpServletResponse response, HttpServletRequest request) {
        long fileLength = downloadFile.length();// 记录文件大小
        long pastLength = 0;// 记录已下载文件大小
        int rangeSwitch = 0;// 0：从头开始的全文下载；1：从某字节开始的下载（bytes=27000-）；2：从某字节开始到某字节结束的下载（bytes=27000-39000）
        long toLength = 0;// 记录客户端需要下载的字节段的最后一个字节偏移量（比如bytes=27000-39000，则这个值是为39000）
        long contentLength = 0;// 客户端请求的字节总量
        String rangeBytes = "";// 记录客户端传来的形如“bytes=27000-”或者“bytes=27000-39000”的内容
        RandomAccessFile raf = null;// 负责读取数据
        OutputStream os = null;// 写出数据
        OutputStream out = null;// 缓冲
        int bsize = 1024;// 缓冲区大小
        byte b[] = new byte[bsize];// 暂存容器

        if (request.getParameter("showheader") != null) {
            Enumeration paramNames = request.getHeaderNames();

            while (paramNames.hasMoreElements()) {
                String name = paramNames.nextElement().toString();
                if (name != null && name.length() > 0) {
                    String value = request.getHeader(name);
                    System.out.println("************" + name + "：" + value);
                }
            }
        }
        String range = request.getHeader("Range");
        // if(range == null)
        // range = "bytes=0-";
        int responseStatus = 206;
        if (range != null && range.trim().length() > 0 && !"null".equals(range)) {// 客户端请求的下载的文件块的开始字节
            responseStatus = javax.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT;
            System.out.println("request.getHeader(\"Range\")=" + range);
            rangeBytes = range.replaceAll("bytes=", "");
            if (rangeBytes.endsWith("-")) {// bytes=969998336-
                rangeSwitch = 1;
                rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                pastLength = Long.parseLong(rangeBytes.trim());
                contentLength = fileLength - pastLength;// 客户端请求的是
                // 969998336之后的字节（包括bytes下标索引为969998336的字节）
            } else {// bytes=1275856879-1275877358
                rangeSwitch = 2;
                String temp0 = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                String temp2 = rangeBytes.substring(rangeBytes.indexOf('-') + 1, rangeBytes.length());
                // bytes=1275856879-1275877358，从第1275856879个字节开始下载
                pastLength = Long.parseLong(temp0.trim());
                toLength = Long.parseLong(temp2);// bytes=1275856879-1275877358，到第
                // 1275877358 个字节结束
                contentLength = toLength - pastLength + 1;// 客户端请求的是
                // 1275856879-1275877358
                // 之间的字节
            }
        } else {// 从开始进行下载
            contentLength = fileLength;// 客户端要求全文下载
        }

        /**
         * 如果设设置了Content-Length，则客户端会自动进行多线程下载。如果不希望支持多线程，则不要设置这个参数。 响应的格式是:
         * Content-Length: [文件的总大小] - [客户端请求的下载的文件块的开始字节]
         * ServletActionContext.getResponse().setHeader("Content-Length", new
         * Long(file.length() - p).toString());
         */
        // 来清除首部的空白行
        //response.reset();
        // 告诉客户端允许断点续传多线程连接下载,响应的格式是:Accept-Ranges: bytes
        response.setHeader("Accept-Ranges", "bytes");
        // 如果是第一次下,还没有断点续传,状态是默认的 200,无需显式设置;响应的格式是:HTTP/1.1

        // response.addHeader("Cache-Control", "max-age=1296000");
        // response.addHeader("Expires", "Fri, 12 Oct 2012 03:43:01 GMT");
        // response.addHeader("Last-Modified", "Tue, 31 Jul 2012 03:58:36 GMT");
        // response.addHeader("Connection", "keep-alive");
        // response.addHeader("ETag", downloadFile.getName() + "-" +
        // downloadFile.lastModified());
        // response.addHeader("Last-Modified", "Thu, 27 Sep 2012 05:24:44 GMT");
        if (rangeSwitch != 0) {
            response.setStatus(responseStatus);
            // 不是从最开始下载，断点下载响应号为206
            // 响应的格式是:
            // Content-Range: bytes [文件块的开始字节]-[文件的总大小 - 1]/[文件的总大小]
            System.out.println("----------------------------片段下载，服务器即将开始断点续传...");
            switch (rangeSwitch) {
                case 1: {// 针对 bytes=27000- 的请求
                    String contentRange = new StringBuffer("bytes ")
                            .append(new Long(pastLength).toString()).append("-")
                            .append(new Long(fileLength - 1).toString())
                            .append("/").append(new Long(fileLength).toString())
                            .toString();
                    response.setHeader("Content-Range", contentRange);
                    break;
                }
                case 2: {// 针对 bytes=27000-39000 的请求
                    String contentRange = range.replace("=", " ") + "/"
                            + new Long(fileLength).toString();
                    response.setHeader("Content-Range", contentRange);
                    break;
                }
                default: {
                    break;
                }
            }
        } else {
            String contentRange = new StringBuffer("bytes ").append("0-")
                    .append(fileLength - 1).append("/").append(fileLength)
                    .toString();
            response.setHeader("Content-Range", contentRange);
            // 是从开始下载
            System.out.println("----------------------------是从开始到最后完整下载！");
        }

        try {
            response.setHeader("Content-Length", String.valueOf(contentLength));
            os = response.getOutputStream();
            out = new BufferedOutputStream(os);
            raf = new RandomAccessFile(downloadFile, "r");
            try {
                long outLength = 0;// 实际输出字节数
                switch (rangeSwitch) {
                    case 0: {// 普通下载，或者从头开始的下载
                        // 同1，没有break
                    }
                    case 1: {// 针对 bytes=27000- 的请求
                        raf.seek(pastLength);// 形如 bytes=969998336- 的客户端请求，跳过
                        // 969998336 个字节
                        int n = 0;
                        while ((n = raf.read(b)) != -1) {
                            out.write(b, 0, n);
                            outLength += n;
                        }
                        // while ((n = raf.read(b, 0, 1024)) != -1) {
                        // out.write(b, 0, n);
                        // }
                        break;
                    }
                    case 2: {
                        // 针对 bytes=27000-39000 的请求，从27000开始写数据
                        raf.seek(pastLength);
                        int n = 0;
                        long readLength = 0;// 记录已读字节数
                        while (readLength <= contentLength - bsize) {// 大部分字节在这里读取
                            n = raf.read(b);
                            readLength += n;
                            out.write(b, 0, n);
                            outLength += n;
                        }
                        if (readLength <= contentLength) {// 余下的不足 1024 个字节在这里读取
                            n = raf.read(b, 0, (int) (contentLength - readLength));
                            out.write(b, 0, n);
                            outLength += n;
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
                System.out.println("Content-Length为：" + contentLength + "；实际输出字节数：" + outLength);
                out.flush();
            } catch (IOException ie) {
                /**
                 * 在写数据的时候， 对于 ClientAbortException 之类的异常，
                 * 是因为客户端取消了下载，而服务器端继续向浏览器写入数据时， 抛出这个异常，这个是正常的。
                 * 尤其是对于迅雷这种吸血的客户端软件， 明明已经有一个线程在读取 bytes=1275856879-1275877358，
                 * 如果短时间内没有读取完毕，迅雷会再启第二个、第三个。。。线程来读取相同的字节段， 直到有一个线程读取完毕，迅雷会 KILL
                 * 掉其他正在下载同一字节段的线程， 强行中止字节读出，造成服务器抛 ClientAbortException。
                 * 所以，我们忽略这种异常
                 */
                // ignore
                ie.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static SimpleMsg uploadFiles(MultipartFile[] files, Long up_id, ResourceService resourceService) {
        List<String> urls = new ArrayList<>();
        SimpleMsg msg = new SimpleMsg(StatusType.SUCCESSFUL,"");
        for (MultipartFile file : files) {
            urls.add(uploadFile(file,up_id,resourceService).getMsg());
        }
        msg.setContent(urls);
        return msg;
    }
}
