package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reply {

    @Id
    public long reply_id;
    public String reply_content;
    public String reply_father;
    public String reply_time;
    public long like_count;
    public long replier_id;
    public String replier_name;
    public String replier_url;
}
