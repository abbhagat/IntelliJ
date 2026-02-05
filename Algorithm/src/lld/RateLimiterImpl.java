package lld;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

interface RateLimiter {
  boolean allowRequest(String userId);
}

class TokenBucket {

  private final int capacity;
  private final int refillRate; // tokens per second
  private final AtomicInteger tokens;
  private long lastRefillTime;

  public TokenBucket(int capacity, int refillRate) {
    this.capacity = capacity;
    this.refillRate = refillRate;
    this.tokens = new AtomicInteger(capacity);
    this.lastRefillTime = System.currentTimeMillis();
  }

  public synchronized boolean tryConsume() {
    refill();
    if (tokens.get() > 0) {
      tokens.decrementAndGet();
      return true;
    }
    return false;
  }

  private void refill() {
    long now = System.currentTimeMillis();
    long secondsPassed = (now - lastRefillTime) / 1000;

    if (secondsPassed > 0) {
      int newTokens = (int) (secondsPassed * refillRate);
      tokens.set(Math.min(capacity, tokens.get() + newTokens));
      lastRefillTime = now;
    }
  }
}

class TokenBucketRateLimiter implements RateLimiter {

  private final ConcurrentHashMap<String, TokenBucket> userBuckets = new ConcurrentHashMap<>();
  private final int capacity;
  private final int refillRate;

  public TokenBucketRateLimiter(int capacity, int refillRate) {
    this.capacity = capacity;
    this.refillRate = refillRate;
  }

  @Override
  public boolean allowRequest(String userId) {
    TokenBucket bucket = userBuckets.computeIfAbsent(userId, k -> new TokenBucket(capacity, refillRate));
    return bucket.tryConsume();
  }
}

public class RateLimiterImpl {

  public static void main(String[] args) {
    RateLimiter limiter = new TokenBucketRateLimiter(5, 1);
    for (int i = 0; i < 10; i++) {
      System.out.println("Request " + i + " allowed: " + limiter.allowRequest("user123")
      );
    }
  }

}
