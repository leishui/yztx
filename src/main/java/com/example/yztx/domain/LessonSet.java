package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;

@Entity
public class LessonSet {
    @Id
    public long id;
    public int lessonCount;
    public long upId;
    public long upTime;
    public int lessonType;
    public String title;
    public String description;
    public String cover_url;
    public long view_count;
    public long comment_count;
    public long collection_count;
    public long like_count;
    public Float score;
    @Transient
    public ArrayList<Lesson> lessons;
}
