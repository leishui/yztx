package com.example.yztx.utils;

import com.example.yztx.constant.Paths;
import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.Resource;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.ResourceService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Objects;

public class FileUtils {
    /**
     * 创建或重命名文件
     * ps：sss.jpg    sss(1).jpg
     * @param from
     * @param toPrefix
     * @param toSuffix
     * @return
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
     * 获取File的   . 前后字串
     * @param from
     * @return
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
     * @param id 上传者id
     * @param name 文件名
     * @param response 不用管
     */
   public static void getFile(String id, String name, HttpServletResponse response){
       File file = new File(Paths.LESSON_PATH + id + "/" + name);
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
       } catch (
               IOException e) {
           e.printStackTrace();
       }
   }

   public static SimpleMsg uploadFile(MultipartFile file,Long up_id,ResourceService resourceService){
       SimpleMsg msg = new SimpleMsg();
       Resource resource = new Resource();
       if (file.isEmpty()) {
           msg.setStatus(StatusType.FAILED);
           msg.setMsg("上传文件为空");
           return msg;
       }
       try {
           File tmp = new File(Paths.LESSON_PATH + up_id, Objects.requireNonNull(file.getOriginalFilename()));
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
           resource.url = file.getOriginalFilename();
           return resourceService.save(resource);
       } catch (IOException e) {
           msg.setStatus(StatusType.FAILED);
           msg.setMsg("上传失败，io异常");
       }
       return msg;
   }
}
