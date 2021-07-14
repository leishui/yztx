package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResourceLabels {
    @Id
    public long resource_id;
    public String resource_label;
}
