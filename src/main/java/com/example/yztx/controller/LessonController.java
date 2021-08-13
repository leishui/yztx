package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.domain.Lesson;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.LessonService;
import com.example.yztx.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class LessonController {

    @Resource
    LessonService lessonService;

    /**
     * showdoc
     *
     * @param name        必选 String 课程名
     * @param res_url     必选 String 对应文件资源url
     * @param up_id       必选 Long 上传者id
     * @param des         必选 String 课程简介
     * @param cover       必选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param lesson_type 必选 Long 课程分类
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/课程
     * @title 上传课程
     * @description 上传课程
     * @method post
     * @url lesson/upload
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/lesson/upload")
    @ResponseBody
    public SimpleMsg upload(@RequestParam("name") String name,
                            @RequestParam("res_url") String res_url,
                            @RequestParam("up_id") Long up_id,
                            @RequestParam("des") String des,
                            @RequestParam("cover") String cover,
                            @RequestParam("source_type") boolean source_type,
                            @RequestParam("lesson_type") Long lesson_type) {
        Lesson lesson = new Lesson();
        lesson.name = name;
        lesson.resource_url = DefaultValues.DEFAULT_RESOURCE_SERVER + res_url;
        lesson.uploader_id = up_id;
        lesson.description = des;
        lesson.cover_url = cover;
        lesson.source_type = source_type;
        lesson.lesson_type = lesson_type;
        lesson.upload_time = Utils.getTimeStamp();
        return lessonService.save(lesson);
    }

    /**
     * showdoc
     *
     * @param name        必选 String 课程名
     * @param id          必选 Long 课程id
     * @param res_url     必选 String 资源url
     * @param des         必选 String 课程简介
     * @param cover       必选 String 封面地址
     * @param source_type 必选 boolean 是否为原创
     * @param lesson_type 必选 Long 课程分类
     * @return {"status":200,"msg":"存储成功","content":null}
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
                                @RequestParam("res_url") String res_url,
                                @RequestParam("des") String des,
                                @RequestParam("cover") String cover,
                                @RequestParam("source_type") boolean source_type,
                                @RequestParam("lesson_type") Long lesson_type) {
        Lesson lesson = lessonService.getById(id);
        lesson.lessonId = id;
        lesson.name = name;
        lesson.resource_url = res_url;
        lesson.description = des;
        lesson.cover_url = cover;
        lesson.source_type = source_type;
        lesson.lesson_type = lesson_type;
        lesson.upload_time = Utils.getTimeStamp();
        return lessonService.save(lesson);
    }

    /**
     * showdoc
     *
     * @param page 必选 int 第几页
     * @param size 必选 int 一页显示多少项
     * @return {"status":200,"msg":null,"content":{"content":[{"lessonId":75,"name":"有趣小实验","description":"做点小实验，培养孩子兴趣","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/bjh/video/dafce6a081b9ced5650beb6c0bc2676e.jpeg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-khwz6ea5027jwz6s/sc/cae_h264_clips/mda-khwz6ea5027jwz6s.mp4?auth_key=1628493964-0-0-0324061e28521e655900dc50ec5073cc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":74,"name":"益智动画片推荐","description":"为宝宝推荐一些益智动画","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/bjh/video/e888d5df4ceb24ddea84155a3dfbd7bd.jpeg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd4.bdstatic.com/mda-khqm7kqhw6ihgsx6/v1-cae/1080p/mda-khqm7kqhw6ihgsx6.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493903-0-0-5fef6dc6107191550176dae14e4b9287&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":73,"name":"益智游戏:手指滑梯","description":"带小朋友做益智小游戏，手指滑梯","uploader_id":0,"cover_url":"https://videopic.bdstatic.com/hk/2004/1587715695d343bc0954f84ae47946d09c7b5c19c9.jpg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd4.bdstatic.com/mda-kdpnvagvsvg7kxck/v1-cae/sc/mda-kdpnvagvsvg7kxck.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493831-0-0-54f5256ec9686dcaff4e557e2218fb43&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":72,"name":"数字7 8简笔画","description":"数字简笔画","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/10b5ce13d52b4d46e5b6ead9b31ddad2.jpg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-hk05pxtpq7ryuv13/sc/mda-hk05pxtpq7ryuv13.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482169-0-0-533fcc8e5f54eac6bef4a68463b1e0ea&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":71,"name":"字母A B 简笔画","description":"字母简笔画","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/a96035a6b19ab69455c9379c7daf0106.jpeg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd3.bdstatic.com/mda-iafvpv61246uzrz7/hd/mda-iafvpv61246uzrz7.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482133-0-0-a85abbcb8428f67a0d14457a5da1b085&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":70,"name":"在家小手工","description":"在家里能轻松做的小手工","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/5184723e7a12ce07964aa62515ce27cf.jpg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd1.bdstatic.com/mda-hj2grffdjxxz8vvu/sc/mda-hj2grffdjxxz8vvu.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482090-0-0-78208108faf79408705478fb32ec5d8c&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":69,"name":"亲子手工-小太阳","description":"做一个小太阳","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/152454715303337b7537eaba2e55e8c5f627abb6f0.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd4.bdstatic.com/mda-idpiu8e55azrbc9f/1080p/mda-idpiu8e55azrbc9f.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482033-0-0-34265507e17ec5040e43ac945a54d43b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":68,"name":"亲子手工-樱桃树","description":"学做樱桃树","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/1524549200030154d93afde3cbcac74a88648e91bb.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-idpjmtmexajy97tv/sc/mda-idpjmtmexajy97tv.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481993-0-0-dd9602f8437d9bb25e2e79081ec18eab&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":67,"name":"亲子手工-彩虹包","description":"教宝宝动手做彩虹包","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/15245494633dd15f2c04f7e1d35a4d59064a36af2f.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-idpjqxh3z2cd6d38/1080p/mda-idpjqxh3z2cd6d38.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481955-0-0-2d4d900e53011c684bf8fcec962cbbbc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":66,"name":"亲子手工-纸袋熊","description":"亲子一起做纸袋熊吧","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/1524642271aacefa3a8aa5bb6aa562e9c9b01b0c29.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-idqn9wbs21tvdqnk/1080p/mda-idqn9wbs21tvdqnk.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481874-0-0-6a5a2a1f5888298848404412c77ea60b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":false,"totalElements":73,"totalPages":8,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":10,"size":10,"number":0,"empty":false}}
     * @catalog 与子同行/课程
     * @title 分页获取所有课程信息
     * @description 分页获取所有课程信息
     * @method get
     * @url lesson/get
     * @return_param status int 成功与否
     * @return_param content Page<Lesson> 课程信息
     */
    @GetMapping("/lesson/get")
    @ResponseBody
    public SimpleMsg getByPage(@RequestParam("page") int page,
                               @RequestParam("size") int size) {
        return lessonService.getByPage(page, size);
    }

    /**
     * showdoc
     *
     * @param page 必选 int 第几页
     * @param size 必选 int 一页显示多少项
     * @return {"status":200,"msg":null,"content":{"content":[{"lessonId":75,"name":"有趣小实验","description":"做点小实验，培养孩子兴趣","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/bjh/video/dafce6a081b9ced5650beb6c0bc2676e.jpeg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-khwz6ea5027jwz6s/sc/cae_h264_clips/mda-khwz6ea5027jwz6s.mp4?auth_key=1628493964-0-0-0324061e28521e655900dc50ec5073cc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":74,"name":"益智动画片推荐","description":"为宝宝推荐一些益智动画","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/bjh/video/e888d5df4ceb24ddea84155a3dfbd7bd.jpeg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd4.bdstatic.com/mda-khqm7kqhw6ihgsx6/v1-cae/1080p/mda-khqm7kqhw6ihgsx6.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493903-0-0-5fef6dc6107191550176dae14e4b9287&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":73,"name":"益智游戏:手指滑梯","description":"带小朋友做益智小游戏，手指滑梯","uploader_id":0,"cover_url":"https://videopic.bdstatic.com/hk/2004/1587715695d343bc0954f84ae47946d09c7b5c19c9.jpg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd4.bdstatic.com/mda-kdpnvagvsvg7kxck/v1-cae/sc/mda-kdpnvagvsvg7kxck.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493831-0-0-54f5256ec9686dcaff4e557e2218fb43&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":72,"name":"数字7 8简笔画","description":"数字简笔画","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/10b5ce13d52b4d46e5b6ead9b31ddad2.jpg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-hk05pxtpq7ryuv13/sc/mda-hk05pxtpq7ryuv13.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482169-0-0-533fcc8e5f54eac6bef4a68463b1e0ea&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":71,"name":"字母A B 简笔画","description":"字母简笔画","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/a96035a6b19ab69455c9379c7daf0106.jpeg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd3.bdstatic.com/mda-iafvpv61246uzrz7/hd/mda-iafvpv61246uzrz7.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482133-0-0-a85abbcb8428f67a0d14457a5da1b085&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":70,"name":"在家小手工","description":"在家里能轻松做的小手工","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/5184723e7a12ce07964aa62515ce27cf.jpg@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd1.bdstatic.com/mda-hj2grffdjxxz8vvu/sc/mda-hj2grffdjxxz8vvu.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482090-0-0-78208108faf79408705478fb32ec5d8c&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":69,"name":"亲子手工-小太阳","description":"做一个小太阳","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/152454715303337b7537eaba2e55e8c5f627abb6f0.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd4.bdstatic.com/mda-idpiu8e55azrbc9f/1080p/mda-idpiu8e55azrbc9f.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482033-0-0-34265507e17ec5040e43ac945a54d43b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":68,"name":"亲子手工-樱桃树","description":"学做樱桃树","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/1524549200030154d93afde3cbcac74a88648e91bb.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-idpjmtmexajy97tv/sc/mda-idpjmtmexajy97tv.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481993-0-0-dd9602f8437d9bb25e2e79081ec18eab&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":67,"name":"亲子手工-彩虹包","description":"教宝宝动手做彩虹包","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/15245494633dd15f2c04f7e1d35a4d59064a36af2f.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-idpjqxh3z2cd6d38/1080p/mda-idpjqxh3z2cd6d38.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481955-0-0-2d4d900e53011c684bf8fcec962cbbbc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null},{"lessonId":66,"name":"亲子手工-纸袋熊","description":"亲子一起做纸袋熊吧","uploader_id":0,"cover_url":"https://pic.rmb.bdstatic.com/1524642271aacefa3a8aa5bb6aa562e9c9b01b0c29.png@s_0,w_660,h_370,q_80","source_type":false,"resource_url":"https://vd2.bdstatic.com/mda-idqn9wbs21tvdqnk/1080p/mda-idqn9wbs21tvdqnk.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481874-0-0-6a5a2a1f5888298848404412c77ea60b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=","view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"score":0.0,"upload_time":0,"lesson_type":0,"lessonSetId":4,"time_long":"[value-16]","user":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":false,"totalElements":73,"totalPages":8,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":10,"size":10,"number":0,"empty":false}}
     * @catalog 与子同行/课程
     * @title 分页获取所有课程系列信息
     * @description 分页获取所有课程系列信息
     * @method get
     * @url lesson/get_set
     * @return_param status int 成功与否
     * @return_param content Page<LessonSet> 课程系列信息
     */
    @GetMapping("/lesson/get_set")
    @ResponseBody
    public SimpleMsg getSetByPage(@RequestParam("page") int page,
                                  @RequestParam("size") int size) {
        return lessonService.getSetByPage(page, size);
    }

}
