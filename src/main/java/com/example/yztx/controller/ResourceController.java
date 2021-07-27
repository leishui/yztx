package com.example.yztx.controller;

import com.example.yztx.constant.Paths;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.ResourceService;
import com.example.yztx.utils.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
public class ResourceController {

    @Resource
    ResourceService resourceService;
    /**
     * showdoc
     * @catalog 与子同行/文件资源
     * @title 上传文件
     * @description 上传文件到服务器
     * @method post
     * @url resource/upload
     * @param file 必选 MultipartFile 所要上传的文件
     * @param up_id 必选 Long 上传者id
     * @return {"status":200,"msg":"?id=3&name=156532545270.jpeg"}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回文件资源url，失败则返回失败原因
     */
    @PostMapping(value = "/resource/upload")
    @ResponseBody
    public SimpleMsg uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("up_id") Long up_id) {
        return FileUtils.uploadFile(file,up_id,resourceService);
    }
    /**
     * showdoc
     * @catalog 与子同行/文件资源
     * @title 获取文件
     * @description 通过上传者id和文件名获取文件
     * @method get
     * @url resource/get
     * @param id 必选 Long 上传者id
     * @param name 必选 String 文件名
     */
    @GetMapping(value = "/resource/get")
    @ResponseBody
    public void getFile(HttpServletResponse response,
                   HttpServletRequest request,
                   @RequestParam("id") String id,
                   @RequestParam("name") String name) {
        File file = new File(Paths.DATA_PATH + id + "/" + name);
        FileUtils.getFile(file,response,request);
        //FileUtils.getFile(id, name, response);
    }

}
