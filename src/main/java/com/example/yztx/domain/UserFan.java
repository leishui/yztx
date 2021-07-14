package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserFan {
    @Id
    public long id;
    public long user_id;
    public long fan_id;
}
