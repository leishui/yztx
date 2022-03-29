# 1、与子同行Java服务端后端

## 1.1、对应安卓客户端：

<https://github.com/leishui/yztx-android/>

## 1.1、用户

### 1.1.1、注册

**简要描述：**

-   用户注册

**请求URL：**

-   user/sign_in

**请求方式：**

-   post

**参数：**

| **参数名** | **是否必选** | **类型** | **说明** |
| ---------- | ------------ | -------- | -------- |
| password   | 必选         | String   | 密码     |
| phone      | 必选         | Long     | 手机号   |
| code       | 必选         | int      | 验证码   |

**返回示例**

```json
{  "status":200,  "msg":"注册成功",  "content":null } 
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回注册成功，失败则返回失败原因 |

**备注**

-   

### 1.1.2、账号登录

**简要描述：**

-   账号登录

**请求URL：**

-   user/login_by_account

**请求方式：**

-   post

**参数：**

| **参数名** | **是否必选** | **类型** | **说明** |
| ---------- | ------------ | -------- | -------- |
| account    | 必选         | String   | 账号     |
| password   | 必选         | String   | 密码     |

**返回示例**

```json
 {  "status":200,  "msg":{  "user_id":1,  "user_name":"用户999",  "account":"999",  "password":"content",  "phone":10086,  "identity":1,  "avatar_url":"1",  "email":null,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  } }
```

**返回参数说明**

| **参数名** | **类型**    | **说明**                               |
| ---------- | ----------- | -------------------------------------- |
| status     | int         | 成功与否                               |
| msg        | User/String | 成功则返回用户信息，失败则返回失败原因 |

**备注**

-   

### 1.1.3、手机号登录

**简要描述：**

-   手机号登录

**请求URL：**

-   user/login_by_phone

**请求方式：**

-   post

**参数：**

| **参数名** | **是否必选** | **类型** | **说明** |
| ---------- | ------------ | -------- | -------- |
| phone      | 必选         | Long     | 手机号   |
| password   | 必选         | String   | 密码     |

**返回示例**

```json
{  "status":200,  "msg":null,  "content":{  "user_id":1,  "user_name":"用户999",  "account":"999",  "password":"content",  "phone":10086,  "identity":1,  "avatar_url":"1",  "email":null,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  } } 
```

 

**返回参数说明**

| **参数名** | **类型** | **说明** |
| ---------- | -------- | -------- |
| status     | int      | 成功与否 |

**备注**

-   

### 1.1.4、获取验证码

**简要描述：**

-   通过手机号获取验证码

**请求URL：**

-   /user/get_code

**请求方式：**

-   get

**参数：**

| **参数名** | **是否必选** | **类型** | **说明** |
| ---------- | ------------ | -------- | -------- |
| phone      | 必选         | Long     | 手机号   |

**返回示例**

```json
{  "status":200,  "msg":null,  "content":"259311" }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                             |
| ---------- | -------- | ------------------------------------ |
| status     | int      | 成功与否                             |
| content    | String   | 成功则返回验证码，失败则返回失败原因 |

**备注**

-   验证码有效时间60秒

### 1.1.5、获取用户信息

**简要描述：**

-   通过用户id获取用户信息

**请求URL：**

-   /user/get_info

**请求方式：**

-   get

**参数：**

| **参数名** | **是否必选** | **类型** | **说明** |
| ---------- | ------------ | -------- | -------- |
| id         | 必选         | Long     | 用户id   |

**返回示例**

```json
{  "status":200,  "msg":"登录成功",  "content":{  "user_id":1,  "user_name":"用户999",  "account":"999",  "password":"content",  "phone":10086,  "identity":1,  "avatar_url":"1",  "email":null,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  } }
```

**返回参数说明**

| **参数名** | **类型**    | **说明**                               |
| ---------- | ----------- | -------------------------------------- |
| status     | int         | 成功与否                               |
| msg        | User/String | 成功则返回用户信息，失败则返回失败原因 |

**备注**

-   

## 1.2、课程

### 1.2.1、上传课程

**简要描述：**

-   上传课程

**请求URL：**

-   lesson/upload

**请求方式：**

-   post

**参数：**

| **参数名**  | **是否必选** | **类型** | **说明**        |
| ----------- | ------------ | -------- | --------------- |
| name        | 必选         | String   | 课程名          |
| res_url     | 必选         | String   | 对应文件资源url |
| up_id       | 必选         | Long     | 上传者id        |
| des         | 必选         | String   | 课程简介        |
| cover       | 必选         | String   | 封面地址        |
| source_type | 必选         | boolean  | 是否为原创      |
| lesson_type | 必选         | Long     | 课程分类        |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

### 1.2.2、更新课程信息

**简要描述：**

-   更新课程信息

**请求URL：**

-   lesson/update_info

**请求方式：**

-   post

**参数：**

| **参数名**  | **是否必选** | **类型** | **说明**   |
| ----------- | ------------ | -------- | ---------- |
| name        | 必选         | String   | 课程名     |
| id          | 必选         | Long     | 课程id     |
| res_url     | 必选         | String   | 资源url    |
| des         | 必选         | String   | 课程简介   |
| cover       | 必选         | String   | 封面地址   |
| source_type | 必选         | boolean  | 是否为原创 |
| lesson_type | 必选         | Long     | 课程分类   |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

### 1.2.3、分页获取所有课程信息

**简要描述：**

-   分页获取所有课程信息

**请求URL：**

-   lesson/get

**请求方式：**

-   get

**参数：**

| **参数名** | **是否必选** | **类型** | **说明**       |
| ---------- | ------------ | -------- | -------------- |
| page       | 必选         | int      | 第几页         |
| size       | 必选         | int      | 一页显示多少项 |

**返回示例**

```json
{  "status":200,  "msg":null,  "content":{  "content":[  {  "lessonId":75,  "name":"有趣小实验",  "description":"做点小实验，培养孩子兴趣",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/bjh/video/dafce6a081b9ced5650beb6c0bc2676e.jpeg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-khwz6ea5027jwz6s/sc/cae_h264_clips/mda-khwz6ea5027jwz6s.mp4?auth_key=1628493964-0-0-0324061e28521e655900dc50ec5073cc&bcevod\_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":74,  "name":"益智动画片推荐",  "description":"为宝宝推荐一些益智动画",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/bjh/video/e888d5df4ceb24ddea84155a3dfbd7bd.jpeg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd4.bdstatic.com/mda-khqm7kqhw6ihgsx6/v1-cae/1080p/mda-khqm7kqhw6ihgsx6.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493903-0-0-5fef6dc6107191550176dae14e4b9287&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":73,  "name":"益智游戏:手指滑梯",  "description":"带小朋友做益智小游戏，手指滑梯",  "uploader_id":0,  "cover_url":"https://videopic.bdstatic.com/hk/2004/1587715695d343bc0954f84ae47946d09c7b5c19c9.jpg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd4.bdstatic.com/mda-kdpnvagvsvg7kxck/v1-cae/sc/mda-kdpnvagvsvg7kxck.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493831-0-0-54f5256ec9686dcaff4e557e2218fb43&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":72,  "name":"数字7 8简笔画",  "description":"数字简笔画",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/10b5ce13d52b4d46e5b6ead9b31ddad2.jpg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource\_url":"https://vd2.bdstatic.com/mda-hk05pxtpq7ryuv13/sc/mda-hk05pxtpq7ryuv13.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482169-0-0-533fcc8e5f54eac6bef4a68463b1e0ea&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":71,  "name":"字母A B 简笔画",  "description":"字母简笔画",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/a96035a6b19ab69455c9379c7daf0106.jpeg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource\_url":"https://vd3.bdstatic.com/mda-iafvpv61246uzrz7/hd/mda-iafvpv61246uzrz7.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482133-0-0-a85abbcb8428f67a0d14457a5da1b085&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":70,  "name":"在家小手工",  "description":"在家里能轻松做的小手工",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/5184723e7a12ce07964aa62515ce27cf.jpg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd1.bdstatic.com/mda-hj2grffdjxxz8vvu/sc/mda-hj2grffdjxxz8vvu.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482090-0-0-78208108faf79408705478fb32ec5d8c&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":69,  "name":"亲子手工-小太阳",  "description":"做一个小太阳",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/152454715303337b7537eaba2e55e8c5f627abb6f0.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd4.bdstatic.com/mda-idpiu8e55azrbc9f/1080p/mda-idpiu8e55azrbc9f.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482033-0-0-34265507e17ec5040e43ac945a54d43b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":68,  "name":"亲子手工-樱桃树",  "description":"学做樱桃树",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/1524549200030154d93afde3cbcac74a88648e91bb.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-idpjmtmexajy97tv/sc/mda-idpjmtmexajy97tv.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481993-0-0-dd9602f8437d9bb25e2e79081ec18eab&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":67,  "name":"亲子手工-彩虹包",  "description":"教宝宝动手做彩虹包",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/15245494633dd15f2c04f7e1d35a4d59064a36af2f.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-idpjqxh3z2cd6d38/1080p/mda-idpjqxh3z2cd6d38.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481955-0-0-2d4d900e53011c684bf8fcec962cbbbc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":66,  "name":"亲子手工-纸袋熊",  "description":"亲子一起做纸袋熊吧",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/1524642271aacefa3a8aa5bb6aa562e9c9b01b0c29.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-idqn9wbs21tvdqnk/1080p/mda-idqn9wbs21tvdqnk.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481874-0-0-6a5a2a1f5888298848404412c77ea60b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  }  ],  "pageable":{  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "pageSize":10,  "pageNumber":0,  "offset":0,  "paged":true,  "unpaged":false  },  "last":false,  "totalElements":73,  "totalPages":8,  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "first":true,  "numberOfElements":10,  "size":10,  "number":0,  "empty":false  } }
```

**返回参数说明**

| **参数名** | **类型** | **说明** |
| ---------- | -------- | -------- |
| status     | int      | 成功与否 |
| content    | Page     | 课程信息 |

**备注**

-   

### 1.2.4、分页获取所有课程系列信息

**简要描述：**

-   分页获取所有课程系列信息

**请求URL：**

-   lesson/get_set

**请求方式：**

-   get

**参数：**

| **参数名** | **是否必选** | **类型** | **说明**       |
| ---------- | ------------ | -------- | -------------- |
| page       | 必选         | int      | 第几页         |
| size       | 必选         | int      | 一页显示多少项 |

**返回示例**

```json
{  "status":200,  "msg":null,  "content":{  "content":[  {  "lessonId":75,  "name":"有趣小实验",  "description":"做点小实验，培养孩子兴趣",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/bjh/video/dafce6a081b9ced5650beb6c0bc2676e.jpeg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-khwz6ea5027jwz6s/sc/cae_h264_clips/mda-khwz6ea5027jwz6s.mp4?auth_key=1628493964-0-0-0324061e28521e655900dc50ec5073cc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment\_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":74,  "name":"益智动画片推荐",  "description":"为宝宝推荐一些益智动画",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/bjh/video/e888d5df4ceb24ddea84155a3dfbd7bd.jpeg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd4.bdstatic.com/mda-khqm7kqhw6ihgsx6/v1-cae/1080p/mda-khqm7kqhw6ihgsx6.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628493903-0-0-5fef6dc6107191550176dae14e4b9287&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view\_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":73,  "name":"益智游戏:手指滑梯",  "description":"带小朋友做益智小游戏，手指滑梯",  "uploader_id":0,  "cover_url":"https://videopic.bdstatic.com/hk/2004/1587715695d343bc0954f84ae47946d09c7b5c19c9.jpg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd4.bdstatic.com/mda-kdpnvagvsvg7kxck/v1-cae/sc/mda-kdpnvagvsvg7kxck.mp4?v\_from_s=hkapp-haokan-nanjing&auth_key=1628493831-0-0-54f5256ec9686dcaff4e557e2218fb43&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":72,  "name":"数字7 8简笔画",  "description":"数字简笔画",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/10b5ce13d52b4d46e5b6ead9b31ddad2.jpg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-hk05pxtpq7ryuv13/sc/mda-hk05pxtpq7ryuv13.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482169-0-0-533fcc8e5f54eac6bef4a68463b1e0ea&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":71,  "name":"字母A B 简笔画",  "description":"字母简笔画",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/a96035a6b19ab69455c9379c7daf0106.jpeg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd3.bdstatic.com/mda-iafvpv61246uzrz7/hd/mda-iafvpv61246uzrz7.mp4?v\_from_s=hkapp-haokan-nanjing&auth_key=1628482133-0-0-a85abbcb8428f67a0d14457a5da1b085&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":70,  "name":"在家小手工",  "description":"在家里能轻松做的小手工",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/5184723e7a12ce07964aa62515ce27cf.jpg@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd1.bdstatic.com/mda-hj2grffdjxxz8vvu/sc/mda-hj2grffdjxxz8vvu.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482090-0-0-78208108faf79408705478fb32ec5d8c&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":69,  "name":"亲子手工-小太阳",  "description":"做一个小太阳",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/152454715303337b7537eaba2e55e8c5f627abb6f0.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd4.bdstatic.com/mda-idpiu8e55azrbc9f/1080p/mda-idpiu8e55azrbc9f.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628482033-0-0-34265507e17ec5040e43ac945a54d43b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":68,  "name":"亲子手工-樱桃树",  "description":"学做樱桃树",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/1524549200030154d93afde3cbcac74a88648e91bb.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-idpjmtmexajy97tv/sc/mda-idpjmtmexajy97tv.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481993-0-0-dd9602f8437d9bb25e2e79081ec18eab&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":67,  "name":"亲子手工-彩虹包",  "description":"教宝宝动手做彩虹包",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/15245494633dd15f2c04f7e1d35a4d59064a36af2f.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-idpjqxh3z2cd6d38/1080p/mda-idpjqxh3z2cd6d38.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481955-0-0-2d4d900e53011c684bf8fcec962cbbbc&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  },  {  "lessonId":66,  "name":"亲子手工-纸袋熊",  "description":"亲子一起做纸袋熊吧",  "uploader_id":0,  "cover_url":"https://pic.rmb.bdstatic.com/1524642271aacefa3a8aa5bb6aa562e9c9b01b0c29.png@s_0,w_660,h_370,q_80",  "source_type":false,  "resource_url":"https://vd2.bdstatic.com/mda-idqn9wbs21tvdqnk/1080p/mda-idqn9wbs21tvdqnk.mp4?v_from_s=hkapp-haokan-nanjing&auth_key=1628481874-0-0-6a5a2a1f5888298848404412c77ea60b&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=",  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "score":0.0,  "upload_time":0,  "lesson_type":0,  "lessonSetId":4,  "time_long":"[value-16]",  "user":null  }  ],  "pageable":{  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "pageSize":10,  "pageNumber":0,  "offset":0,  "paged":true,  "unpaged":false  },  "last":false,  "totalElements":73,  "totalPages":8,  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "first":true,  "numberOfElements":10,  "size":10,  "number":0,  "empty":false  } }
```

**返回参数说明**

| **参数名** | **类型** | **说明**     |
| ---------- | -------- | ------------ |
| status     | int      | 成功与否     |
| content    | Page     | 课程系列信息 |

**备注**

-   

## 1.3、文件资源

### 1.3.1、上传文件

**简要描述：**

-   上传文件到服务器

**请求URL：**

-   resource/upload

**请求方式：**

-   post

**参数：**

| **参数名** | **是否必选** | **类型**      | **说明**       |
| ---------- | ------------ | ------------- | -------------- |
| file       | 必选         | MultipartFile | 所要上传的文件 |
| up_id      | 必选         | Long          | 上传者id       |

**返回示例**

```json
{"status":200,"msg":"?id=3&name=156532545270.jpeg"，"content":null}
```

**返回参数说明**

| **参数名** | **类型** | **说明**                                  |
| ---------- | -------- | ----------------------------------------- |
| status     | int      | 成功与否                                  |
| msg        | String   | 成功则返回文件资源url，失败则返回失败原因 |

**备注**

-   

### 1.3.2、获取文件

**简要描述：**

-   通过上传者id和文件名获取文件

**请求URL：**

-   resource/get

**请求方式：**

-   get

**参数：**

| **参数名** | **是否必选** | **类型** | **说明** |
| ---------- | ------------ | -------- | -------- |
| id         | 必选         | Long     | 上传者id |
| name       | 必选         | String   | 文件名   |

### 1.3.3、上传多个文件

**简要描述：**

-   上传多个文件到服务器

**请求URL：**

-   resource/upload_files

**请求方式：**

-   post

**参数：**

| **参数名** | **是否必选** | **类型**        | **说明**           |
| ---------- | ------------ | --------------- | ------------------ |
| files      | 必选         | MultipartFile[] | 所要上传的多个文件 |
| up_id      | 必选         | Long            | 上传者id           |

**返回示例**

```json
{"status":200,"msg":"["?id=3&name=156532545270.jpeg","?id=3&name=156532545270.jpeg"]"，"content":null}
```

**返回参数说明**

| **参数名** | **类型** | **说明**                                  |
| ---------- | -------- | ----------------------------------------- |
| status     | int      | 成功与否                                  |
| msg        | String   | 成功则返回文件资源url，失败则返回失败原因 |

**备注**

-   

## 1.4、短视频

### 1.4.1、上传短视频

**简要描述：**

-   上传短视频

**请求URL：**

-   stvd/upload

**请求方式：**

-   post

**参数：**

| **参数名**  | **是否必选** | **类型** | **说明**        |
| ----------- | ------------ | -------- | --------------- |
| title       | 必选         | String   | 短视频名        |
| res_url     | 必选         | String   | 对应文件资源url |
| up_id       | 必选         | Long     | 上传者id        |
| des         | 必选         | String   | 短视频简介      |
| cover       | 必选         | String   | 封面地址        |
| source_type | 必选         | boolean  | 是否为原创      |
| stvd_type   | 必选         | Long     | 短视频分类      |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

### 1.4.2、更新短视频信息

**简要描述：**

-   更新短视频信息

**请求URL：**

-   stvd/update_info

**请求方式：**

-   post

**参数：**

| **参数名**  | **是否必选** | **类型** | **说明**   |
| ----------- | ------------ | -------- | ---------- |
| title       | 必选         | String   | 短视频名   |
| id          | 必选         | Long     | 短视频id   |
| des         | 必选         | String   | 短视频简介 |
| cover       | 必选         | String   | 封面地址   |
| source_type | 必选         | boolean  | 是否为原创 |
| stvd_type   | 必选         | Long     | 短视频分类 |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

## 1.5、贴子

### 1.5.1、上传贴子

**简要描述：**

-   上传贴子

**请求URL：**

-   post/upload

**请求方式：**

-   post

**参数：**

| **参数名**  | **是否必选** | **类型** | **说明**       |
| ----------- | ------------ | -------- | -------------- |
| name        | 必选         | String   | 贴子名         |
| content     | 必选         | String   | 贴子内容       |
| resources   | 可选         | String   | 上传的图片资源 |
| up_id       | 必选         | Long     | 上传者id       |
| source_type | 必选         | boolean  | 是否为原创     |
| post_type   | 必选         | Long     | 贴子分类       |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

### 1.5.2、更新贴子信息

**简要描述：**

-   更新贴子信息

**请求URL：**

-   post/update_info

**请求方式：**

-   post

**参数：**

| **参数名**  | **是否必选** | **类型** | **说明**   |
| ----------- | ------------ | -------- | ---------- |
| name        | 必选         | String   | 贴子名     |
| id          | 必选         | Long     | 贴子id     |
| content     | 必选         | String   | 贴子内容   |
| source_type | 必选         | boolean  | 是否为原创 |
| post_type   | 必选         | Long     | 贴子分类   |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

### 1.5.3、分页获取所有贴子信息

**简要描述：**

-   分页获取所有贴子信息

**请求URL：**

-   post/get

**请求方式：**

-   get

**参数：**

| **参数名** | **是否必选** | **类型** | **说明**       |
| ---------- | ------------ | -------- | -------------- |
| page       | 必选         | int      | 第几页         |
| size       | 必选         | int      | 一页显示多少项 |

**返回示例**

```json
{  "status":200,  "msg":null,  "content":{  "content":[  {  "postId":30,  "post_name":"孩子害怕怎么办",  "post_content":"呜呜呜怕死了QAQ",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dScreenshot_2021-08-13-16-40-03-177_com.miui.gallery(1).jpg\\",\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dScreenshot_2021-08-13-16-40-11-490_com.miui.gallery(1).jpg\\"]",  "uploader_id":11,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628844040,  "post_type":1,  "user":{  "userId":11,  "user_name":"丑",  "account":"17784454287",  "password":"123456",  "phone":17784454287,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png",  "des":"",  "date":0,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-40-03-177_com.miui.gallery(1).jpg",  "https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-40-11-490_com.miui.gallery(1).jpg"  ]  },  {  "postId":29,  "post_name":"想认识一下这位帅哥",  "post_content":"求个联系方式呗",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dScreenshot_2021-08-13-16-35-40-034_com.miui.gallery.jpg\\"]",  "uploader_id":2,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628843823,  "post_type":1,  "user":{  "userId":2,  "user_name":"admin",  "account":"admin",  "password":"123456",  "phone":110,  "identity":4,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "des":"",  "date":0,  "wallet":1,  "subscription_count":0,  "fan_count":0,  "collection_count":0  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-40-034_com.miui.gallery.jpg"  ]  },  {  "postId":28,  "post_name":"孩子社恐怎么办？点进来专家告诉你！",  "post_content":"多半是装的，打几顿就好了",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dScreenshot_2021-08-13-16-35-34-093_com.miui.gallery.jpg\\",\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dScreenshot_2021-08-13-16-35-31-119_com.miui.gallery.jpg\\",\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dScreenshot_2021-08-13-16-35-26-946_com.miui.gallery.jpg\\"]",  "uploader_id":1,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628843787,  "post_type":1,  "user":{  "userId":1,  "user_name":"GAIye",  "account":"18782082258",  "password":"rg1234",  "phone":18782082258,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=1&name=avartar.png",  "des":"handsome",  "date":0,  "wallet":88888,  "subscription_count":0,  "fan_count":666666,  "collection_count":520  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-34-093_com.miui.gallery.jpg",  "https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-31-119_com.miui.gallery.jpg",  "https://yztx.entergx.cn/resource/get?id=1&name=Screenshot_2021-08-13-16-35-26-946_com.miui.gallery.jpg"  ]  },  {  "postId":27,  "post_name":"孩子不吃饭怎么办",  "post_content":"呜呜呜呜呜",  "post_resources":null,  "uploader_id":11,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628841785,  "post_type":1,  "user":{  "userId":11,  "user_name":"丑",  "account":"17784454287",  "password":"123456",  "phone":17784454287,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png",  "des":"",  "date":0,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  },  "postResourcesList":null  },  {  "postId":22,  "post_name":"不会有人要请假吧不会吧不会吧不会吧",  "post_content":"不会真有人还要请假吧",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d11\\\\u0026name\\\\u003dthumbimg-16272858034076847e5fea898fba2ead68eb9f9583e5e.jpg\\"]",  "uploader_id":11,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628759549,  "post_type":1,  "user":{  "userId":11,  "user_name":"丑",  "account":"17784454287",  "password":"123456",  "phone":17784454287,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png",  "des":"",  "date":0,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=11&name=thumbimg-16272858034076847e5fea898fba2ead68eb9f9583e5e.jpg"  ]  },  {  "postId":21,  "post_name":"范记平帅吗。",  "post_content":"范记平到底是帅还是丑？这是一个值得深思的哲学问题，现在就让我们一起来讨论一下，范记平到底帅不帅",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d3\\\\u0026name\\\\u003dSnapchat-1693069787.jpg\\"]",  "uploader_id":3,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628741264,  "post_type":1,  "user":{  "userId":3,  "user_name":"国旭",  "account":"18560849224",  "password":"11",  "phone":18560849224,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png",  "des":"",  "date":0,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=3&name=Snapchat-1693069787.jpg"  ]  },  {  "postId":19,  "post_name":"范记平丑吗。",  "post_content":"简直不摆了，丑的要死",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003d787cd55a9d515679.jpg\\",\\"https://yztx.entergx.cn/resource/get?id\\\\u003d1\\\\u0026name\\\\u003dhdImg_607a4704011d8c39c34d10e25e73d23d1627092883586.jpg\\"]",  "uploader_id":1,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628674289,  "post_type":1,  "user":{  "userId":1,  "user_name":"GAIye",  "account":"18782082258",  "password":"rg1234",  "phone":18782082258,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=1&name=avartar.png",  "des":"handsome",  "date":0,  "wallet":88888,  "subscription_count":0,  "fan_count":666666,  "collection_count":520  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=1&name=787cd55a9d515679.jpg",  "https://yztx.entergx.cn/resource/get?id=1&name=hdImg_607a4704011d8c39c34d10e25e73d23d1627092883586.jpg"  ]  },  {  "postId":18,  "post_name":"认真工作!",  "post_content":"禁 止 摸 鱼 ！",  "post_resources":"[\\"https://yztx.entergx.cn/resource/get?id\\\\u003d11\\\\u0026name\\\\u003dimg-1628318007246d85f3aee6d605df99e95b95ca7b2dc29.jpg\\"]",  "uploader_id":11,  "source_type":true,  "view_count":0,  "comment_count":0,  "collection_count":0,  "like_count":0,  "upload_time":1628673374,  "post_type":1,  "user":{  "userId":11,  "user_name":"丑",  "account":"17784454287",  "password":"123456",  "phone":17784454287,  "identity":1,  "avatar_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png",  "des":"",  "date":0,  "wallet":0,  "subscription_count":0,  "fan_count":0,  "collection_count":0  },  "postResourcesList":[  "https://yztx.entergx.cn/resource/get?id=11&name=img-1628318007246d85f3aee6d605df99e95b95ca7b2dc29.jpg"  ]  }  ],  "pageable":{  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "pageSize":10,  "pageNumber":0,  "offset":0,  "paged":true,  "unpaged":false  },  "last":true,  "totalElements":8,  "totalPages":1,  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "first":true,  "numberOfElements":8,  "size":10,  "number":0,  "empty":false  } }
```

**返回参数说明**

| **参数名** | **类型** | **说明** |
| ---------- | -------- | -------- |
| status     | int      | 成功与否 |
| content    | Page     | 贴子信息 |

**备注**

-   

## 1.6、评论

### 1.6.1、获取包含回复的评论列表

**简要描述：**

-   发表回复

**请求URL：**

-   comment/save_reply

**请求方式：**

-   post

**参数：**

| **参数名**    | **是否必选** | **类型** | **说明**         |
| ------------- | ------------ | -------- | ---------------- |
| reply_id      | 必选         | Long     | 回复id           |
| replyFather   | 必选         | Long     | 所评论的父评论id |
| replier_id    | 必选         | Long     | 回复者id         |
| reply_content | 必选         | String   | 回复内容         |

**返回示例**

```json
{  "status":200,  "msg":"存储成功",  "content":null }
```

**返回参数说明**

| **参数名** | **类型** | **说明**                               |
| ---------- | -------- | -------------------------------------- |
| status     | int      | 成功与否                               |
| msg        | String   | 成功则返回存储成功，失败则返回失败原因 |

**备注**

-   

### 1.6.2、获取评论列表

**简要描述：**

-   分页获取评论列表

**请求URL：**

-   comment/get_comments

**请求方式：**

-   post

**参数：**

| **参数名** | **是否必选** | **类型** | **说明**                 |
| ---------- | ------------ | -------- | ------------------------ |
| comment_id | 必选         | Long     | 评论id                   |
| type       | 必选         | int      | 类型（课程/贴子/短视频） |
| page       | 必选         | int      | 第几页                   |
| size       | 必选         | int      | 一页显示多少项           |

**返回示例**

```json
{  "status":200,  "msg":null,  "content":{  "content":[  {  "id":65,  "type":0,  "commentId":2,  "comment_content":"魔iOS你明明哦婆婆婆婆在一起赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰",  "comment_time":1628731083,  "like_count":0,  "reply_count":0,  "commentator_id":3,  "commentator_name":"国旭",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png",  "replies":null  },  {  "id":64,  "type":0,  "commentId":2,  "comment_content":"可口可口可乐了来了来了考虑考虑考虑考虑V5图啦啦啦可口可乐了看看可口可乐了看看可口可乐了看看可口可乐了看看考虑考虑考虑考虑拉拉裤突突突可乐了可口可乐了",  "comment_time":1628730957,  "like_count":0,  "reply_count":0,  "commentator_id":3,  "commentator_name":"国旭",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png",  "replies":null  },  {  "id":60,  "type":0,  "commentId":2,  "comment_content":"\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n",  "comment_time":1628643263,  "like_count":0,  "reply_count":0,  "commentator_id":3,  "commentator_name":"国旭",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png",  "replies":null  },  {  "id":54,  "type":0,  "commentId":2,  "comment_content":"妈的\\n",  "comment_time":1628317817,  "like\_count":0,  "reply_count":0,  "commentator_id":22,  "commentator_name":"用户15978912182",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "replies":null  },  {  "id":37,  "type":0,  "commentId":2,  "comment_content":"a",  "comment_time":1628299602,  "like_count":0,  "reply_count":0,  "commentator_id":21,  "commentator_name":"用户17742319999",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "replies":null  },  {  "id":35,  "type":0,  "commentId":2,  "comment_content":"1",  "comment_time":1628299570,  "like_count":0,  "reply_count":0,  "commentator_id":21,  "commentator_name":"用户17742319999",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "replies":null  },  {  "id":34,  "type":0,  "commentId":2,  "comment_content":"。",  "comment_time":1628299555,  "like_count":0,  "reply_count":0,  "commentator_id":21,  "commentator_name":"用户17742319999",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "replies":null  },  {  "id":29,  "type":0,  "commentId":2,  "comment_content":"１５７５３３６９８５７\\n",  "comment_time":1628298768,  "like_count":0,  "reply_count":0,  "commentator_id":23,  "commentator_name":"用户15978912183",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "replies":null  },  {  "id":28,  "type":0,  "commentId":2,  "comment_content":"１５７５３３６９８５７",  "comment_time":1628298727,  "like_count":0,  "reply_count":0,  "commentator_id":23,  "commentator_name":"用户15978912183",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg",  "replies":null  },  {  "id":23,  "type":0,  "commentId":2,  "comment_content":"",  "comment_time":1628233553,  "like_count":0,  "reply_count":0,  "commentator_id":11,  "commentator_name":"丑",  "commentator_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png",  "replies":null  }  ],  "pageable":{  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "pageSize":10,  "pageNumber":0,  "offset":0,  "paged":true,  "unpaged":false  },  "last":false,  "totalElements":23,  "totalPages":3,  "sort":{  "sorted":true,  "unsorted":false,  "empty":false  },  "first":true,  "numberOfElements":10,  "size":10,  "number":0,  "empty":false  } }
```

**返回参数说明**

| **参数名** | **类型** | **说明** |
| ---------- | -------- | -------- |
| status     | int      | 成功与否 |
| msg        | String   | 信息     |
| content    | Page     |          |
