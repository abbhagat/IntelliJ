package lld.ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucket {

  private final int capacity;
  private final int refillRate; // tokens per second
  private final AtomicInteger tokens;
  private long lastRefillTime;

  public TokenBucket(int capacity, int refillRate) {
    this.capacity       = capacity;
    this.refillRate     = refillRate;
    this.tokens         = new AtomicInteger(capacity);
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
