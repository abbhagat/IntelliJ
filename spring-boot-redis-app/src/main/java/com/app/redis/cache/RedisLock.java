package com.app.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.util.List;

/**
 *  Minimal Single instance Redis lock ( SET NX PX + owner-checked renew/release).
 *  It guards an idempotent job, so a lost lock only costs duplicate work, never correctness.
 */

@Slf4j
@Component
public class RedisLock {

  private static final String REDIS_RENEW_SCRIPT   = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('pexpire', KEYS[1], ARGV[2]) else return 0 end";
  private static final String REDIS_RELEASE_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

  private static final RedisScript<Long> RENEW    = RedisScript.of(REDIS_RENEW_SCRIPT, Long.class);
  private static final RedisScript<Long> RELEASE  = RedisScript.of(REDIS_RELEASE_SCRIPT, Long.class);

  private final StringRedisTemplate stringRedisTemplate;

  public RedisLock(StringRedisTemplate stringRedisTemplate) {
    this.stringRedisTemplate = stringRedisTemplate;
  }

  public boolean tryAcquire(String key, String value, Duration ttl) {
    return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, value, ttl));
  }

  // return TRUE if we still own the lock and its TTL was extended
  public boolean renew(String key, String value, Duration ttl) {
    Long result = stringRedisTemplate.execute(RENEW, List.of(key), value, String.valueOf(ttl.toMillis()));
    return result != null && result == 1L;
  }

  // Best Effort: if Redis is unreachable the lock simply expires via it's TTL
  public void release(String key, String value) {
    try {
      stringRedisTemplate.execute(RELEASE, List.of(key), value);
    }catch (RuntimeException e) {
      log.info("Could not release lock {}; it will expire on it's own : {}", key, e.toString());
    }
  }
}
