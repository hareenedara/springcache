package com.example.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {
    @Value("${redis.hostname}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;



    @Bean
    public LettuceConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory(redisHost,redisPort);
    }

    public RedisCacheConfiguration cacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(300))
                .disableCachingNullValues();
    }
    public RedisCacheManager cacheManager(){
        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(cacheConfiguration()).transactionAware().build();
    }

}
