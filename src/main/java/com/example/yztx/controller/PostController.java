package com.example.yztx.controller;

import com.example.yztx.domain.Post;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.PostService;
import com.example.yztx.utils.Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class PostController {

    @Resource
    PostService postService;

    /**
     * showdoc
     *
     * @param name        必选 String 贴子名
     * @param content     必选 String 贴子内容
     * @param resources   可选 String 上传的图片资源
     * @param up_id       必选 Long 上传者id
     * @param source_type 必选 boolean 是否为原创
     * @param post_type   必选 Long 贴子分类
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/贴子
     * @title 上传贴子
     * @description 上传贴子
     * @method post
     * @url post/upload
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/post/upload")
    @ResponseBody
    public SimpleMsg upload(@RequestParam("name") String name,
                            @RequestParam("content") String content,
                            @RequestParam("resources") String resources,
                            @RequestParam("up_id") Long up_id,
                            @RequestParam("source_type") boolean source_type,
                            @RequestParam("post_type") Long post_type) {
        Post post = new Post();
        post.post_name = name;
        if (!resources.isEmpty())
            post.post_resources = resources;
        post.post_content = content;
        post.uploader_id = up_id;
        post.source_type = source_type;
        post.post_type = post_type;
        post.upload_time = Utils.getTimeStamp();
        return postService.save(post);
    }

    /**
     * showdoc
     *
     * @param name        必选 String 贴子名
     * @param id          必选 Long 贴子id
     * @param content     必选 String 贴子内容
     * @param source_type 必选 boolean 是否为原创
     * @param post_type   必选 Long 贴子分类
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/贴子
     * @title 更新贴子信息
     * @description 更新贴子信息
     * @method post
     * @url post/update_info
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/post/update_info")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("name") String name,
                                @RequestParam("id") Long id,
                                @RequestParam("content") String content,
                                @RequestParam("source_type") boolean source_type,
                                @RequestParam("post_type") Long post_type) {
        Post post = postService.getById(id);
        post.postId = id;
        post.post_name = name;
        post.post_content = content;
        post.source_type = source_type;
        post.post_type = post_type;
        post.upload_time = Utils.getTimeStamp();
        return postService.save(post);
    }

    /**
     * showdoc
     *
     * @param page 必选 int 第几页
     * @param size 必选 int 一页显示多少项
     * @return {"status":200,"msg":null,"content":{"content":[{"postId":30,"post_name":"孩子害怕怎么办","post_content":"呜呜呜怕死了QAQ","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dScreenshot_2021-08-13-16-40-03-177_com.miui.gallery(1).jpg\",\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dScreenshot_2021-08-13-16-40-11-490_com.miui.gallery(1).jpg\"]","uploader_id":11,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628844040,"post_type":1,"user":{"userId":11,"user_name":"丑","account":"17784454287","password":"123456","phone":17784454287,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png","des":"","date":0,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-40-03-177_com.miui.gallery(1).jpg","https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-40-11-490_com.miui.gallery(1).jpg"]},{"postId":29,"post_name":"想认识一下这位帅哥","post_content":"求个联系方式呗","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dScreenshot_2021-08-13-16-35-40-034_com.miui.gallery.jpg\"]","uploader_id":2,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628843823,"post_type":1,"user":{"userId":2,"user_name":"admin","account":"admin","password":"123456","phone":110,"identity":4,"avatar_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","des":"","date":0,"wallet":1,"subscription_count":0,"fan_count":0,"collection_count":0},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-40-034_com.miui.gallery.jpg"]},{"postId":28,"post_name":"孩子社恐怎么办？点进来专家告诉你！","post_content":"多半是装的，打几顿就好了","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dScreenshot_2021-08-13-16-35-34-093_com.miui.gallery.jpg\",\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dScreenshot_2021-08-13-16-35-31-119_com.miui.gallery.jpg\",\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dScreenshot_2021-08-13-16-35-26-946_com.miui.gallery.jpg\"]","uploader_id":1,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628843787,"post_type":1,"user":{"userId":1,"user_name":"GAIye","account":"18782082258","password":"rg1234","phone":18782082258,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=1&name=avartar.png","des":"handsome","date":0,"wallet":88888,"subscription_count":0,"fan_count":666666,"collection_count":520},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-34-093_com.miui.gallery.jpg","https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-31-119_com.miui.gallery.jpg","https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-26-946_com.miui.gallery.jpg"]},{"postId":27,"post_name":"孩子不吃饭怎么办","post_content":"呜呜呜呜呜","post_resources":null,"uploader_id":11,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628841785,"post_type":1,"user":{"userId":11,"user_name":"丑","account":"17784454287","password":"123456","phone":17784454287,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png","des":"","date":0,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0},"postResourcesList":null},{"postId":22,"post_name":"不会有人要请假吧不会吧不会吧不会吧","post_content":"不会真有人还要请假吧","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d11\\u0026name\\u003dthumbimg-16272858034076847e5fea898fba2ead68eb9f9583e5e.jpg\"]","uploader_id":11,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628759549,"post_type":1,"user":{"userId":11,"user_name":"丑","account":"17784454287","password":"123456","phone":17784454287,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png","des":"","date":0,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=11&name=thumbimg-16272858034076847e5fea898fba2ead68eb9f9583e5e.jpg"]},{"postId":21,"post_name":"范记平帅吗。","post_content":"范记平到底是帅还是丑？这是一个值得深思的哲学问题，现在就让我们一起来讨论一下，范记平到底帅不帅","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d3\\u0026name\\u003dSnapchat-1693069787.jpg\"]","uploader_id":3,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628741264,"post_type":1,"user":{"userId":3,"user_name":"国旭","account":"18560849224","password":"11","phone":18560849224,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","des":"","date":0,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=3&name=Snapchat-1693069787.jpg"]},{"postId":19,"post_name":"范记平丑吗。","post_content":"简直不摆了，丑的要死","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003d787cd55a9d515679.jpg\",\"https://yztx.entergx.cn/resource/get?id\\u003d1\\u0026name\\u003dhdImg_607a4704011d8c39c34d10e25e73d23d1627092883586.jpg\"]","uploader_id":1,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628674289,"post_type":1,"user":{"userId":1,"user_name":"GAIye","account":"18782082258","password":"rg1234","phone":18782082258,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=1&name=avartar.png","des":"handsome","date":0,"wallet":88888,"subscription_count":0,"fan_count":666666,"collection_count":520},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=1&name=787cd55a9d515679.jpg","https://yztx.entergx.cn/resource/get?id=1&name=hdImg_607a4704011d8c39c34d10e25e73d23d1627092883586.jpg"]},{"postId":18,"post_name":"认真工作!","post_content":"禁 止 摸 鱼 ！","post_resources":"[\"https://yztx.entergx.cn/resource/get?id\\u003d11\\u0026name\\u003dimg-1628318007246d85f3aee6d605df99e95b95ca7b2dc29.jpg\"]","uploader_id":11,"source_type":true,"view_count":0,"comment_count":0,"collection_count":0,"like_count":0,"upload_time":1628673374,"post_type":1,"user":{"userId":11,"user_name":"丑","account":"17784454287","password":"123456","phone":17784454287,"identity":1,"avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png","des":"","date":0,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0},"postResourcesList":["https://yztx.entergx.cn/resource/get?id=11&name=img-1628318007246d85f3aee6d605df99e95b95ca7b2dc29.jpg"]}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":8,"totalPages":1,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":8,"size":10,"number":0,"empty":false}}
     * @catalog 与子同行/贴子
     * @title 分页获取所有贴子信息
     * @description 分页获取所有贴子信息
     * @method get
     * @url post/get
     * @return_param status int 成功与否
     * @return_param content Page<Post> 贴子信息
     */
    @GetMapping("/post/get")
    @ResponseBody
    public SimpleMsg getByPage(@RequestParam("page") int page,
                               @RequestParam("size") int size) {
        return postService.getByPage(page, size);
    }

}
