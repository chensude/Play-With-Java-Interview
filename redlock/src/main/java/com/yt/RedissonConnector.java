package com.yt;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取Redisson类
 */
@Component
public class RedissonConnector {
    RedissonClient redisson;

    @PostConstruct
    public void init() {
        this.redisson = Redisson.create();
    }

    public RedissonClient getClient() {
        return redisson;
    }
}
