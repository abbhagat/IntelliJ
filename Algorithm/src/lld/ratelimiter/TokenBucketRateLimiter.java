package lld.ratelimiter;

public class TokenBucketRateLimiter {

  public static void main(String[] args) throws InterruptedException {
    RateLimiter limiter = new RateLimiterImpl(5, 1);
    for (int i = 0; i < 10; i++) {
      if (i == 5 || i == 9) {
        Thread.sleep(2000);
      }
      System.out.println("Request " + i + " allowed: " + limiter.allowRequest("user123")
      );
    }
  }
}
