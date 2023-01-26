package com.gsupl.framework.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author LGH
 * @Date 2022/11/10 16:11
 * @Version 1.0
 */
@Configuration
public class RedisConfig {
   @Bean
   public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory connectionFactory){
       RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
       redisTemplate.setConnectionFactory(connectionFactory);
       //1、解决key序列化
       redisTemplate.setKeySerializer(new StringRedisSerializer());
       //2、解决value序列化
       redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
       return redisTemplate;
   }

}
