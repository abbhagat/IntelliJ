package com.app.redis.service;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

  private final StringRedisTemplate stringRedisTemplate;

  public RedisService(StringRedisTemplate stringRedisTemplate) {
    this.stringRedisTemplate = stringRedisTemplate;
  }

  public void save(String key, String value) {
    stringRedisTemplate.opsForValue().set(key, value);
  }

  public void saveWithExpiry(String key, String value, long seconds) {
    stringRedisTemplate.opsForValue().set(key, value, Duration.ofSeconds(seconds));
  }

  public String get(String key) {
    return stringRedisTemplate.opsForValue().get(key);
  }

  public boolean delete(String key) {
    return Boolean.TRUE.equals(stringRedisTemplate.delete(key));
  }

  public boolean exists(String key) {
    return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
  }
}
