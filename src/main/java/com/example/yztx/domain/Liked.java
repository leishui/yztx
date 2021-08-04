package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Liked {
    @Id
    public int type;
    public long user_id;
    public boolean status;
    public long creat_time;
}
