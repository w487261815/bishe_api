package com.example.demo.service.Impl;

import com.example.demo.service.AnnimalTokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.UUID;


@Service(value = "gouyanFilmToken")
public class AnnimalTokenImpl implements AnnimalTokens {
    @Resource
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public int delelteUsername(String userName) {
        redisTemplate.delete(userName);
        return 0;
    }

    @Override
    public String insert(String username) {
        String token= UUID.randomUUID()+"";
        redisTemplate.opsForValue().set(token,username, Duration.ofMinutes(60L));
        return token;
    }

    @Override
    public int updateDuration(String token) {
        return 0;
    }

    @Override
    public String getToken(Long userId) {

        return null;
    }

    @Override
    public String getUsername(String token) {
        Object user=redisTemplate.opsForValue().get(token);
        System.out.println(user.toString());
        return user.toString();
    }
}
