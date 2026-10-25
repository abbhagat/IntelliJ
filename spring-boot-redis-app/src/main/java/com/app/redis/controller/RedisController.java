package com.app.redis.controller;

import com.app.redis.service.RedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

  private final RedisService redisService;

  public RedisController(RedisService redisService) {
    this.redisService = redisService;
  }

  @PostMapping("/{key}")
  public String save(@PathVariable String key, @RequestBody String value) {
    redisService.save(key, value);
    return "Value saved successfully";
  }

  @GetMapping("/{key}")
  public String get(@PathVariable String key) {
    String value = redisService.get(key);
    return value != null ? value : "Key not found";
  }

  @DeleteMapping("/{key}")
  public String delete(@PathVariable String key) {
    return redisService.delete(key) ? "Key deleted" : "Key not found";
  }
}
