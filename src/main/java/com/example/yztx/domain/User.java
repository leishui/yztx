package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    public long user_id;
    public String user_name;
    public String account;
    public String password;
    public int phone;
    public int identity;
    public String avatar_url;
    public String email;
    public long wallet;
    public long subscription_count;
    public long fan_count;
    public long collection_count;
}
