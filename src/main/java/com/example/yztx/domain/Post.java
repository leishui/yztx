package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Post  {
    @Id
    public long post_id;
    public String post_name;
    public String post_content;
    public long uploader_id;
    public boolean source_type;
    public long view_count;
    public long comment_count;
    public long collection_count;
    public long like_count;
    public long upload_time;
    public long post_type;
}
