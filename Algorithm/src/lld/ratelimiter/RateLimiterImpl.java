package lld.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterImpl implements RateLimiter {

  private final Map<String, TokenBucket> tokenBucketMap;
  private final int capacity;
  private final int refillRate;

  public RateLimiterImpl(int capacity, int refillRate) {
    this.tokenBucketMap = new ConcurrentHashMap<>();
    this.capacity       = capacity;
    this.refillRate     = refillRate;
  }

  @Override
  public boolean allowRequest(String userId) {
    TokenBucket bucket = tokenBucketMap.get(userId);
    if (bucket == null) {
      bucket = new TokenBucket(capacity, refillRate);
      tokenBucketMap.put(userId, bucket);
    }
    return bucket.consumeTokens();
  }
}
