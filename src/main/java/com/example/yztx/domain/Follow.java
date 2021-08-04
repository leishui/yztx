package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Follow {
    @Id
    public long from_id;
    public long to_id;
}
