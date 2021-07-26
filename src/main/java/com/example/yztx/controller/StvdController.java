package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.Paths;
import com.example.yztx.constant.StatusType;
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
     * @catalog 与子同行短视频
     * @title 短视频标题，上传
     * @description 短视频描述，上传到服务器
     * @method post
     * @url stvd/upload_stvd
     * @param file 必选 MultipartFile 所要上传的文件
     * @param up_id 必选 Long 上传者id
     * @return {"status":200,"msg":1}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返短视频id，失败则返回失败原因
     */
    @PostMapping(value = "/stvd/upload_stvd")
    @ResponseBody
    public SimpleMsg uploadStvd(@RequestParam("file") MultipartFile file,
                                @RequestParam("up_id") Long up_id) {
        SimpleMsg msg = new SimpleMsg();
        Stvd stvd = new Stvd();
        if (file.isEmpty()) {
            msg.setStatus(StatusType.FAILED);
            msg.setMsg("上传文件为空");
            return msg;
        }
        try {
            File tmp = new File(Paths.STVD_PATH + up_id, Objects.requireNonNull(file.getOriginalFilename()));
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
            stvd.uploader_id = up_id;
            stvd.resource_url = file.getOriginalFilename();
            return stvdService.save(Utils.uploadStvd(stvd));
        } catch (IOException e) {
            msg.setStatus(StatusType.FAILED);
            msg.setMsg("上传失败，io异常");
        }
        return msg;
    }
    /**
     * showdoc
     * @catalog 与子同行/短视频
     * @title 获取短视频
     * @description 通过上传者id和文件名获取视频流
     * @method get
     * @url stvd/{id}
     * @param id 必选 Long 上传者id
     * @param name 必选 String 文件名
     */
    @GetMapping(value = "/stvd/{id}")
    @ResponseBody
    public void getStvd(HttpServletResponse response,
                          @PathVariable String id,
                          @RequestParam("name") String name) {
        File file = new File(Paths.STVD_PATH + id + "/" + name);
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
     * @catalog 短视频
     * @title 更新短视频信息
     * @description 更新短视频信息
     * @method post
     * @url stvd/update_info
     * @param title 必选 String 短视频标题
     * @param id 必选 Long短视频id
     * @param des 必选 String短视频简介
     * @param source_type 必选 boolean 是否为原创
     * @return {"status":200,"msg":1}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返短视频id，失败则返回失败原因
     */
    @PostMapping(value = "/stvd/update_info")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("title") String title,
                                @RequestParam("id") Long id,
                                @RequestParam("up_id") Long up_id,
                                @RequestParam("des") String des,
                               // @RequestParam(value = "cover_url",defaultValue = DefaultValues.DEFAULT_COVER)String cover,
                                @RequestParam("source_type")boolean source_type) {
        Stvd stvd= stvdService.getById(id);
        stvd.stvd_id = id;
        stvd.uploader_id=up_id;
        stvd.title = title;
        stvd.description = des;
        stvd.resource_url = DefaultValues.DEFAULT_RESOURCE_SERVER + up_id + "?name=" + stvdService.getUrl(id);
        //stvd.cover_url = cover;
        stvd.source_type = source_type;
        return stvdService.save(stvd);
    }

}
