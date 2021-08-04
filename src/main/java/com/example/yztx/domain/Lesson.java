package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Lesson
{
    @Id
    public long lessonId;
    public String name;
    public String description;
    public long uploader_id;
    public String cover_url;
    public boolean source_type;
    public String resource_url;
    public long view_count;
    public long comment_count;
    public long collection_count;
    public long like_count;
    public float score;
    public long upload_time;
    public long lesson_type;
    public long lessonSetId;
    @Transient
    public User user;
}
