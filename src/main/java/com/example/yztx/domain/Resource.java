package com.example.yztx.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resource {
    @Id
    public long id;
    public String url;
    public long up_id;

    @Override
    public String toString() {
        return "?id=" + up_id + "&name=" + url;
    }
}
