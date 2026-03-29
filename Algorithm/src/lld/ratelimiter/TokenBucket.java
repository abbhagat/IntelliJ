package lld.ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.Integer.min;

public class TokenBucket {

  private final int capacity;
  private final int refillRate; // tokens per second
  private final AtomicInteger availableTokens;
  private long lastRefillTime;

  public TokenBucket(int capacity, int refillRate) {
    this.capacity        = capacity;
    this.refillRate      = refillRate;
    this.availableTokens = new AtomicInteger(capacity);  // initial full capacity token available
    this.lastRefillTime  = System.currentTimeMillis();
  }

  public synchronized boolean consumeTokens() {
    refill();
    if (availableTokens.get() > 0) {
      availableTokens.decrementAndGet();
      return true;
    }
    return false;
  }

  private void refill() {
    long now = System.currentTimeMillis();
    long secondsPassed = (now - lastRefillTime) / 1000;
    if (secondsPassed > 0) {
      int newTokens = (int) (secondsPassed * refillRate);
      availableTokens.set(min(capacity, availableTokens.get() + newTokens));
      lastRefillTime = now;
    }
  }
}
