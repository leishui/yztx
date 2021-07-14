package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statistics {
    @Id
    public long statistics_id;
    public long user_count_all;
    public long resource_count_all;
    public long view_count_all;
    public int user_count_new;
    public long resource_count_new;
    public long view_count_new;
}
