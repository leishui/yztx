package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.Paths;
import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.Stvd;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.StvdService;
import com.example.yztx.utils.FileUtils;
import com.example.yztx.utils.RedisUtils;
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
public class StvdController {
    @Resource

    private StvdService stvdService;

    /**
     * showdoc
     *
     * @param title       必选 String 短视频名
     * @param res_url     必选 String 对应文件资源url
     * @param up_id       必选 Long 上传者id
     * @param des         必选 String 短视频简介
     * @param cover       必选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param stvd_type   必选 Long 短视频分类
     * @return {"status":200,"msg":"存储成功"}
     * @catalog 与子同行/短视频
     * @title 上传短视频
     * @description 上传短视频
     * @method post
     * @url stvd/upload
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/stvd/upload")
    @ResponseBody
    public SimpleMsg upload(@RequestParam("title") String title,
                            @RequestParam("res_url") String res_url,
                            @RequestParam("up_id") Long up_id,
                            @RequestParam("des") String des,
                            @RequestParam("cover") String cover,
                            @RequestParam("source_type") boolean source_type,
                            @RequestParam("stvd_type") Long stvd_type) {
        Stvd stvd = new Stvd();
        stvd.title = title;
        stvd.resource_url = DefaultValues.DEFAULT_RESOURCE_SERVER + res_url;
        stvd.uploader_id = up_id;
        stvd.description = des;
        stvd.cover_url = cover;
        stvd.source_type = source_type;
        stvd.stvd_id = stvd_type;
        stvd.upload_time = Utils.getTimeStamp();
        return stvdService.save(stvd);
    }

    /**
     * showdoc
     *
     * @param title       必选 String 短视频名
     * @param id          必选 Long 短视频id
     * @param des         必选 String 短视频简介
     * @param cover       必选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param stvd_type   必选 Long 短视频分类
     * @return {"status":200,"msg":"存储成功"}
     * @catalog 与子同行/短视频
     * @title 更新短视频信息
     * @description 更新短视频信息
     * @method post
     * @url stvd/update_info
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/stvd/update_info")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("title") String title,
                                @RequestParam("res_url") String res_url,
                                @RequestParam("des") String des,
                                @RequestParam("id") Long id,
                                @RequestParam("cover") String cover,
                                @RequestParam("source_type") boolean source_type,
                                @RequestParam("stvd_type") Long stvd_type) {
        Stvd stvd = stvdService.getById(id);
        stvd.stvd_id = id;
        stvd.title = title;
        stvd.description = des;
        stvd.resource_url = res_url;
        stvd.cover_url = cover;
        stvd.source_type = source_type;
        stvd.stvd_type = stvd_type;
        stvd.upload_time = Utils.getTimeStamp();
        return stvdService.save(stvd);
    }

}

