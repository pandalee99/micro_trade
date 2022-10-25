package com.sodse.trade.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig{

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    //自定义Redis缓存管理器
    @Bean
    public RedisCacheManager redisCacheManager(){
        //Redis加锁的写入器
        RedisCacheWriter writer=RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
        //这里注入了Redis连接工厂
        //启动Redis缓存默认设置
        RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig();
        //设置JDK序列化器
        //设置10秒超时
        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));
        //禁用前缀
        config=config.disableKeyPrefix();
        //设置10秒超时
//        config=config.entryTtl(Duration.ofSeconds(30));
        config=config.entryTtl(Duration.ofDays(1));
        //创建缓存管理器
        RedisCacheManager redisCacheManager=new RedisCacheManager( writer,config);
        return redisCacheManager;
    }

//    @Bean
//    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        // 设置值（value）的序列化采用Jackson2JsonRedisSerializer。
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        // 设置键（key）的序列化采用StringRedisSerializer。
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

}