package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Reply {

    @Id
    public long id;
    public String reply_content;
    public long replyFather;
    public long reply_time;
    public long like_count;
    public long replier_id;
    @Transient
    public String replier_name;
    @Transient
    public String replier_url;
}
