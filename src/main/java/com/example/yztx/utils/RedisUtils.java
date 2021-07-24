package com.example.yztx.utils;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisUtils {

    private final Jedis jedis = new Jedis("127.0.0.1");

    public void add(String key, String value) {
        jedis.set(key, value);
        jedis.expire(key, 60);
    }

    public String get(String key){
        return jedis.get(key);
    }
}
