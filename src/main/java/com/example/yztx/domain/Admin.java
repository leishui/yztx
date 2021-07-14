package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    public int admin_id;
    public String name;
    public String account;
    public int jurisdiction;
}
