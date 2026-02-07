package lld.ratelimiter;

public class TokenBucketRateLimiter {

  public static void main(String[] args) {
    RateLimiter limiter = new RateLimiterImpl(5, 1);
    for (int i = 0; i < 10; i++) {
      System.out.println("Request " + i + " allowed: " + limiter.allowRequest("user123")
      );
    }
  }
}
