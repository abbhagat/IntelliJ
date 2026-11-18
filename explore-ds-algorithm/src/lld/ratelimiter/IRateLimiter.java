package lld.ratelimiter;

public interface IRateLimiter {
  boolean allowRequest(String userId);
}
