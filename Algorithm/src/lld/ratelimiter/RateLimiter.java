package lld.ratelimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter implements IRateLimiter {

  private final Map<String, TokenBucket> tokenBucketMap;
  private final int capacity;
  private final int refillRate;

  public RateLimiter(int capacity, int refillRate) {
    this.tokenBucketMap = new ConcurrentHashMap<>();
    this.capacity       = capacity;
    this.refillRate     = refillRate;
  }

  @Override
  public boolean allowRequest(String userId) {
    TokenBucket tokenBucket = tokenBucketMap.get(userId);
    if (tokenBucket == null) {
      tokenBucket = new TokenBucket(capacity, refillRate);
      tokenBucketMap.put(userId, tokenBucket);
    }
    return tokenBucket.consumeTokens();
  }
}
