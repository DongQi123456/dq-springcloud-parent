package com.repository;

import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepository<T> {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add(String key, Long time, T t){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(t), time, TimeUnit.MINUTES);
    }

    public void add(String key, Long time, List<T> ts){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(ts), time, TimeUnit.MINUTES);
    }

    public T get(String key,Class<T> obj){
        Gson gson = new Gson();
        T t = null;
        String json = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(json))
            t = gson.fromJson(json, obj);
        return t;
    }

    public List<T> getList(String key){
        Gson gson = new Gson();
        List<T> ts = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(listJson))
            ts = gson.fromJson(listJson, new TypeToken<List<T>>(){}.getType());
        return ts;
    }

    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }

}
