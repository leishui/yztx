package com.example.yztx.domain;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.Paths;

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
        return DefaultValues.DEFAULT_RESOURCE_SERVER + "?id=" + up_id + "&name=" + url;
    }
}
