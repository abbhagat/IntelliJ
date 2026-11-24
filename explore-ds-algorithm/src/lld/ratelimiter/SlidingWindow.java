package lld.ratelimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SlidingWindow implements IRateLimiter {

  private final int  maxRequest;
  private final long windowMillis;
  private final Map<String, Deque<Long>> requestTimestamps;

  public SlidingWindow(int maxRequest, long windowMillis) {
    this.maxRequest        = maxRequest;
    this.windowMillis      = windowMillis;
    this.requestTimestamps = new ConcurrentHashMap<>();
  }

  @Override
  public synchronized boolean allowRequest(String userId) {
    long now = System.currentTimeMillis();
    Deque<Long> deque = requestTimestamps.computeIfAbsent(userId, key -> new ArrayDeque<>());
    while (!deque.isEmpty() && deque.peekFirst() <= now - windowMillis) {  // Remove requests outside the sliding window
      deque.pollFirst();
    }
    if (deque.size() >= maxRequest) {   // Limit reached
      return false;
    }
    deque.addLast(now);             // Add current request
    return true;
  }
}
