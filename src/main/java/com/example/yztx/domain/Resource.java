package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {
    @Id
    long id;
    String url;
}
