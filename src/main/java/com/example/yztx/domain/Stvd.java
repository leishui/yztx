package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stvd {

    @Id
    public long stvd_id;
    public String title;
    public String description;
    public long uploader_id;
    public String cover_url;
    public boolean source_type;
    public String resource_url;
    public long view_count;
    public long comment_count;
    public long collection_count;
    public long like_count;
    public long upload_time;
    public long stvd_type;
}
