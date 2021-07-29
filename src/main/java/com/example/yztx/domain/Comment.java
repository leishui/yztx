package com.example.yztx.domain;

import org.springframework.data.domain.Page;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Comment
{
    @Id
    public long id;
    public int type;
    public long comment_id;
    public String comment_content;
    public long comment_time;
    public long like_count;
    public long reply_count;
    public long commentator_id;
    @Transient
    public String commentator_name;
    @Transient
    public String commentator_url;
    @Transient
    public Page<Reply> replies;
}
