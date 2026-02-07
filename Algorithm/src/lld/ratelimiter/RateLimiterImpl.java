package lld.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class RateLimiterImpl implements RateLimiter {

  private final Map<String, TokenBucket> userBucketMap = new ConcurrentHashMap<>();
  private final int capacity;
  private final int refillRate;

  public RateLimiterImpl(int capacity, int refillRate) {
    this.capacity = capacity;
    this.refillRate = refillRate;
  }

  @Override
  public boolean allowRequest(String userId) {
//    TokenBucket bucket = userBucketMap.computeIfAbsent(userId, k -> new TokenBucket(capacity, refillRate));
    TokenBucket bucket = userBucketMap.get(userId);
    if (bucket == null) {
      bucket = new TokenBucket(capacity, refillRate);
      userBucketMap.put(userId, bucket);
    }
    return bucket.tryConsume();
  }
}
