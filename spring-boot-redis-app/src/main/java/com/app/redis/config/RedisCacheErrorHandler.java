package com.app.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * This handler deliberately suppresses cache exceptions after logging them. Spring can then proceed without a successful cache read or write.
 * Important production caveats:
 * - Cache reads can fall through to Oracle DB, but this can significantly increase database load during a Redis outage.
 * - If cache eviction fails after an update or delete, stale data may remain in Redis until its TTL expires. For stricter consistency, implement reliable invalidation, such as after-commit events or an outbox-based invalidation process.
 * - Add metrics and alerts for Redis failures, cache hit rate, database load, and cache fallback activity. Avoid logging sensitive cached values.
 * - Use rate limiting, circuit breaking where appropriate, and database connection-pool limits to prevent a cache outage from overwhelming PostgreSQL.
 * This is a best-effort cache design. It is appropriate when PostgreSQL can serve requests during a Redis outage. If Redis is mandatory to correctly process a request, do not silently suppress failures for that operation.
 */
@Slf4j
@Configuration
public class RedisCacheErrorHandler {

  @Bean
  public CacheErrorHandler cacheErrorHandler() {

    return new CacheErrorHandler() {

      @Override
      public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        log.warn( "Redis cache GET failed; cache={}, key={}", cache.getName(), key, exception);
      }

      @Override
      public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        log.warn("Redis cache PUT failed; cache={}, key={}", cache.getName(), key, exception);
      }

      @Override
      public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        log.error("Redis cache EVICT failed; cache={}, key={}", cache.getName(), key, exception);
      }

      @Override
      public void handleCacheClearError(RuntimeException exception, Cache cache) {
        log.error("Redis cache CLEAR failed; cache={}", cache.getName(), exception);
      }
    };
  }
}
