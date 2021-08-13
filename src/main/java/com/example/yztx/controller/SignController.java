package com.example.yztx.controller;


import com.example.yztx.domain.Sign;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.SignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class SignController {

    @Resource
    SignService signService;

    /**
     * showdoc
     *
     * @param signer_id   必选 Long 签到者id
     * @param signer_name 必选 String 签到者账户名
     * @param signer_url  必选 String 签到者头像地址
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/签到
     * @title 签到
     * @description 发起签到
     * @method post
     * @url sign/upload
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping("/sign/upload")
    @ResponseBody
    public SimpleMsg saveSign(
            @RequestParam("signer_url") String signer_url,
            @RequestParam("signer_id") Long signer_id,
            @RequestParam("signer_name") String signer_name,
            @RequestParam("sign_time") Long sign_time) {

        Sign sign = new Sign();
        sign.signer_id = signer_id;
        sign.signer_name = signer_name;
        sign.signer_url = signer_url;
        sign.sign_time = sign_time;
        return signService.saveSign(sign);
    }
}


