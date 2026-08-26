package lld.ratelimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class SlidingWindow implements IRateLimiter {

  private final int maxRequest;
  private final long windowMillis;
  private final Map<String, Deque<Long>> requestTimestamps;

  public SlidingWindow(int maxRequest, long windowMillis) {
    this.maxRequest        = maxRequest;
    this.windowMillis      = windowMillis;
    this.requestTimestamps = new HashMap<>();
  }

  @Override
  public synchronized boolean allowRequest(String userId) {
    long now = System.currentTimeMillis();
    Deque<Long> queue = requestTimestamps.computeIfAbsent(userId, key -> new ArrayDeque<>());
    while (!queue.isEmpty() && queue.peekFirst() <= now - windowMillis) {  // Remove requests outside the sliding window
      queue.pollFirst();
    }
    if (queue.size() >= maxRequest) {   // Limit reached
      return false;
    }
    queue.offerLast(now);   // Add current request
    return true;
  }
}
