package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class fan {
    @Id
    public long fan_id;
    public long user_id;
}
