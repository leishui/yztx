package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;

@Entity
public class Post  {
    @Id
    public long postId;
    public String post_name;
    public String post_content;
    public String post_resources;
    public long uploader_id;
    public boolean source_type;
    public long view_count;
    public long comment_count;
    public long collection_count;
    public long like_count;
    public long upload_time;
    public long post_type;
    @Transient
    public User user;
    @Transient
    public ArrayList<String> postResourcesList;
}
