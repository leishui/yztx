package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.Paths;
import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.LessonService;
import com.example.yztx.utils.FileUtils;
import com.example.yztx.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Objects;

@RestController
public class LessonController {

    @Resource
    LessonService lessonService;
    /**
     * showdoc
     * @catalog 与子同行/课程
     * @title 上传课程
     * @description 上传课程到服务器
     * @method post
     * @url lesson/upload_lesson
     * @param file 必选 MultipartFile 所要上传的文件
     * @param up_id 必选 Long 上传者id
     * @return {"status":200,"msg":1}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回课程id，失败则返回失败原因
     */
    @PostMapping(value = "/lesson/upload_lesson")
    @ResponseBody
    public SimpleMsg uploadLesson(@RequestParam("file") MultipartFile file, @RequestParam("up_id") Long up_id) {
        SimpleMsg msg = new SimpleMsg();
        Lesson lesson = new Lesson();
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
            lesson.uploader_id = up_id;
            lesson.resource_url = file.getOriginalFilename();
            return lessonService.save(Utils.uploadLesson(lesson));
        } catch (IOException e) {
            msg.setStatus(StatusType.FAILED);
            msg.setMsg("上传失败，io异常");
        }
        return msg;
    }
    /**
     * showdoc
     * @catalog 与子同行/课程
     * @title 获取视频
     * @description 通过上传者id和文件名获取视频流
     * @method get
     * @url lesson/{id}
     * @param id 必选 Long 上传者id
     * @param name 必选 String 文件名
     */
    @GetMapping(value = "/lesson/{id}")
    @ResponseBody
    public void getLesson(HttpServletResponse response,
                   @PathVariable String id,
                   @RequestParam("name") String name) {
        File file = new File(Paths.LESSON_PATH + id + "/" + name);
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
    /**
     * showdoc
     * @catalog 与子同行/课程
     * @title 更新课程信息
     * @description 更新课程信息
     * @method post
     * @url lesson/update_info
     * @param name 必选 String 课程名
     * @param id 必选 Long 课程id
     * @param des 必选 String 课程简介
     * @param cover 可选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param lesson_type 必选 Long 课程分类
     * @return {"status":200,"msg":1}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回课程id，失败则返回失败原因
     */
    @PostMapping(value = "/lesson/update_info")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("name") String name,
                                @RequestParam("id") Long id,
                                @RequestParam("des") String des,
                                @RequestParam(value = "cover_url",defaultValue = DefaultValues.DEFAULT_COVER)String cover,
                                @RequestParam("source_type")boolean source_type,
                                @RequestParam("lesson_type")Long lesson_type){
        Lesson lesson = lessonService.getById(id);
        lesson.lesson_id = id;
        lesson.name = name;
        lesson.description = des;
        lesson.cover_url = cover;
        lesson.source_type = source_type;
        lesson.lesson_type = lesson_type;
        return lessonService.save(lesson);
    }

}
