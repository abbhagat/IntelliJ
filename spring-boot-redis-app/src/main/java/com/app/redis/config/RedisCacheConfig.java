package com.app.redis.config;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import tools.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
public class RedisCacheConfig {

  /**
   * This configuration provides:
   * - TTL: Cached entries expire after five minutes.
   * - Key namespacing: Keys are prefixed with product-service:.
   * - JSON values: Java objects are serialized instead of storing raw Java heap references.
   * - No null caching: A database miss won't create a cached null entry.
   * - Shared cache: All application pods use the same Redis deployment through the configured connection factory.
   * The five-minute TTL is an example, not a universal production value.
   * Choose it based on how frequently your data changes and how stale the application can tolerate it.
   */

  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory, ObjectMapper objectMapper) {
    GenericJacksonJsonRedisSerializer jsonSerializer = new GenericJacksonJsonRedisSerializer(objectMapper);
    StringRedisSerializer stringSerializer = new StringRedisSerializer();
    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(5))
        .disableCachingNullValues()
        .computePrefixWith(cacheName -> "department-service:" + cacheName + ":")
        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer))
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonSerializer));
    return RedisCacheManager.builder(connectionFactory)
        .cacheDefaults(redisCacheConfiguration)
        .build();
  }
}
