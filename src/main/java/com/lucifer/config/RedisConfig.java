package com.lucifer.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lucifer on 2019/5/15 21:58
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public RedissonClient redissonClient() {
        Config config = null;
        try {
            config = Config.fromYAML(RedisConfig.class.getClassLoader().getResource("redisson-single.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Redisson.create(config);
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

    @Bean
    public CacheManager cacheManager() {
        Map<String, CacheConfig> configMap = new HashMap<>();
        configMap.put("account", new CacheConfig(0, 0));
        return new RedissonSpringCacheManager(redissonClient(), configMap);
    }
}
