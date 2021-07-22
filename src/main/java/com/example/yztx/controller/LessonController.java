package com.example.yztx.controller;

import com.example.yztx.constant.Paths;
import com.example.yztx.constant.StatusType;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.utils.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class LessonController {

    @ResponseBody
    @PostMapping(value = "/lesson/upload_lesson")
    public SimpleMsg fileUpload(@RequestParam("uploadFile") MultipartFile file) {
        SimpleMsg msg = new SimpleMsg();
        if (file.isEmpty()) {
            msg.setStatus(StatusType.FAILED);
            msg.setMsg("Please select a file to upload");
            return msg;
        }
        try {
            File tmp = new File(Paths.LESSON_PATH, file.getOriginalFilename());
            if (!tmp.getParentFile().exists()) {
                tmp.getParentFile().mkdirs();
            }
            String[] fileInfo = FileUtils.getFileInfo(tmp);
            File orRenameFile = FileUtils.createOrRenameFile(tmp, fileInfo[0], fileInfo[1]);
            if (tmp.renameTo(orRenameFile)) {
                file.transferTo(orRenameFile);
            } else {
                file.transferTo(tmp);
            }
            msg.setStatus(StatusType.SUCCESSFUL);
            msg.setMsg("You successfully upload" + file.getOriginalFilename());
        } catch (IOException e) {
            msg.setStatus(StatusType.FAILED);
            msg.setMsg("Uploaded file failed");
        }
        return msg;

    }

    @GetMapping(value = "/lesson/{id}")
    @ResponseBody
    public void le(HttpServletResponse response, @PathVariable String id) {
        File file = new File(Paths.LESSON_PATH + id + ".mp4");
        try (InputStream in = new FileInputStream(file);
             ServletOutputStream out = response.getOutputStream();) {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            int length;
            byte[] buffer = new byte[4 * 1024];
            // 向前台输出视频流
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败, 文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
