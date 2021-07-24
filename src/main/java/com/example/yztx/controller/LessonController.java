package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.domain.Lesson;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.LessonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class LessonController {

    @Resource
    LessonService lessonService;

    /**
     * showdoc
     *
     * @param name        必选 String 课程名
     * @param res_id      必选 Long 对应文件资源id
     * @param up_id       必选 Long 上传者id
     * @param des         必选 String 课程简介
     * @param cover       可选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param lesson_type 必选 Long 课程分类
     * @return {"status":200,"msg":1}
     * @catalog 与子同行/课程
     * @title 更新课程信息
     * @description 更新课程信息
     * @method post
     * @url lesson/update_info
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/lesson/upload")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("name") String name,
                                @RequestParam("res_id") Long res_id,
                                @RequestParam("up_id") Long up_id,
                                @RequestParam("des") String des,
                                @RequestParam(value = "cover", defaultValue = DefaultValues.DEFAULT_COVER) String cover,
                                @RequestParam("source_type") boolean source_type,
                                @RequestParam("lesson_type") Long lesson_type) {
        Lesson lesson = new Lesson();
        lesson.name = name;
        lesson.resource_url = DefaultValues.DEFAULT_RESOURCE_SERVER + up_id + "?name=" + lessonService.getUrl(res_id);
        lesson.uploader_id = up_id;
        lesson.description = des;
        lesson.cover_url = cover;
        lesson.source_type = source_type;
        lesson.lesson_type = lesson_type;
        return lessonService.save(lesson);
    }

    /**
     * showdoc
     *
     * @param name        必选 String 课程名
     * @param id          必选 Long 课程id
     * @param des         必选 String 课程简介
     * @param cover       可选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param lesson_type 必选 Long 课程分类
     * @return {"status":200,"msg":1}
     * @catalog 与子同行/课程
     * @title 更新课程信息
     * @description 更新课程信息
     * @method post
     * @url lesson/update_info
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/lesson/update_info")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("name") String name,
                                @RequestParam("id") Long id,
                                @RequestParam("des") String des,
                                @RequestParam(value = "cover", defaultValue = DefaultValues.DEFAULT_COVER) String cover,
                                @RequestParam("source_type") boolean source_type,
                                @RequestParam("lesson_type") Long lesson_type) {
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
