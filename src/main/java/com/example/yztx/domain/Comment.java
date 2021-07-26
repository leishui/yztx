package com.example.yztx.domain;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment
{
    @Id
    public int comment_id;
    public String comment_content;
    public String comment_time;
    public int comment_likenum;
    public int comment_replynum;
    public int commentator_id;
    public String commentator_name;
    public String commentator_url;


}
