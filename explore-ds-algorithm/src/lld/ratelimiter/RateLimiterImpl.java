package lld.ratelimiter;

public class RateLimiterImpl {

  public static void main(String[] args) throws InterruptedException {
    IRateLimiter rateLimiter = new TokenBucketRateLimiter(5, 1);
    for (int i = 1; i <= 7; i++) {
      if (i % 5 == 0) {
        Thread.sleep(1000);
      }
      System.out.println("Request " + i + " allowed: " + rateLimiter.allowRequest("user" + i));
    }

    IRateLimiter limiter = new SlidingWindow(5, 10_000);
    String clientId = "user-123";
    for (int i = 1; i <= 7; i++) {
      System.out.println("Request " + i + (limiter.allowRequest(clientId) ? " allowed" : " rejected"));
    }
  }
}
