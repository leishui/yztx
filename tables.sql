create database yztx;
use yztx;
/*
 用户表
 */
create table user
(
    user_id bigint auto_increment,
    user_name varchar(255) not null,
    account varchar(255) not null,
    password varchar(255) not null,
    phone int not null,
    identity int not null,
    avatar_url varchar(255) not null,
    email varchar(255),
    wallet bigint default 0 not null,
    subscription_count bigint default 0 not null,
    fan_count bigint default 0 not null,
    collection_count bigint default 0 not null,
    constraint user_pk
        primary key (user_id)
);
/*
 课程信息表
 */
create table lesson
(
    lesson_id bigint auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    uploader_id bigint not null,
    cover_url varchar(255) not null,
    source_type bool not null,
    resource_url varchar(255) not null,
    view_count bigint default 0 not null,
    comment_count bigint default 0 not null,
    collection_count bigint default 0 not null,
    like_count bigint default 0 not null,
    score float default 0 not null,
    upload_time bigint not null,
    lesson_type bigint not null,
    constraint lesson_pk
        primary key (lesson_id)
);
/*
 资源标签表
 */
create table resource_labels
(
    resource_id bigint not null,
    resource_label varchar(255) not null,
    constraint resource_labels_pk
        primary key (resource_id)
);
/*
 帖子信息表
 */
create table post
(
    post_id bigint auto_increment,
    post_name varchar(255) not null,
    post_content varchar(255) not null,
    uploader_id bigint not null,
    source_type bool not null,
    view_count bigint default 0 not null,
    comment_count bigint default 0 not null,
    collection_count bigint default 0 not null,
    like_count bigint default 0 not null,
    upload_time bigint not null,
    post_type bigint not null,
    constraint post_pk
        primary key (post_id)
);
/*
 短视频信息表
 */
create table stvd
(
    stvd_id bigint auto_increment,
    title varchar(255) not null,
    description varchar(255) not null,
    uploader_id bigint not null,
    cover_url varchar(255) not null,
    source_type bool not null,
    resource_url varchar(255) not null,
    view_count bigint default 0 not null,
    comment_count bigint default 0 not null,
    collection_count bigint default 0 not null,
    like_count bigint default 0 not null,
    upload_time bigint not null,
    stvd_type bigint not null,
    constraint stvd_pk
        primary key (stvd_id)
);
# 订阅关系
create table user_fan
(
    user_id bigint not null,
    fan_id bigint not null,
    id bigint auto_increment,
    constraint user_fan_pk
        primary key (id)
);
# 管理员
create table `admin`
(
    admin_id     int auto_increment
        primary key,
    name         varchar(255) not null,
    account      varchar(255) not null,
    jurisdiction int          not null
);

# 每日数据统计
create table statistics
(
    statistics_id bigint auto_increment,
    user_count_all bigint not null,
    resource_count_all bigint not null,
    view_count_all bigint not null,
    user_count_new int not null,
    resource_count_new bigint not null,
    view_count_new bigint not null,
    date date not null,
    constraint statistics_pk
        primary key (statistics_id)
);
