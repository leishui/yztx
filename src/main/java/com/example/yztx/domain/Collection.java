package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collection {
@Id
public long user_id;
public long creat_time;
public String user_name;
public long type;
public boolean status;
}
