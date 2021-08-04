package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    public long userId;
    public String user_name;
    public String account;
    public String password;
    public long phone;
    public int identity;
    public String avatar_url;
    public String des;
    public long wallet;
    public long subscription_count;
    public long fan_count;
    public long collection_count;
}
