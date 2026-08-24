package lld.ratelimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class SlidingWindow implements IRateLimiter {

  private final int maxRequests;
  private final long windowMillis;
  private final Map<String, Deque<Long>> requestTimestamps;

  public SlidingWindow(int maxRequests, long windowMillis) {
    this.maxRequests = maxRequests;
    this.windowMillis = windowMillis;
    this.requestTimestamps = new HashMap<>();
  }

  @Override
  public synchronized boolean allowRequest(String clientId) {
    long now = System.currentTimeMillis();
    Deque<Long> timestamps = requestTimestamps.computeIfAbsent(clientId, key -> new ArrayDeque<>());
    // Remove requests outside the sliding window
    while (!timestamps.isEmpty() && timestamps.peekFirst() <= now - windowMillis) {
      timestamps.pollFirst();
    }
    if (timestamps.size() >= maxRequests) {   // Limit reached
      return false;
    }
    timestamps.offerLast(now);   // Add current request
    return true;
  }
}
