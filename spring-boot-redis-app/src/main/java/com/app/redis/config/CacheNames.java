package com.app.redis.config;

// Single source of truth for cache names and Redis keys layout (shared by the cache manager and thw warmer)
public final class CacheNames {

  public static final String KEY_PREFIX = "department-service";
  public static final String DEPARTMENTS = "departments";

  private CacheNames() {
    // private constructor to prevent instantiation
  }

  public static String prefixFor(String cacheName) {
    return KEY_PREFIX + cacheName + ":";
  }

  public static String getDepartmentKey(Long departmentId) {
    return prefixFor(DEPARTMENTS) + departmentId;
  }
}
