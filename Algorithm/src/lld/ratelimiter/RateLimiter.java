package lld.ratelimiter;

interface RateLimiter {
  boolean allowRequest(String userId);
}
