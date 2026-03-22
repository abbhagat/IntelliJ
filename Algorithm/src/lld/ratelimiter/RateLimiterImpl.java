package lld.ratelimiter;

public class RateLimiterImpl {

  public static void main(String[] args) throws InterruptedException {
    IRateLimiter rateLimiter = new RateLimiter(5, 1);
    for (int i = 1; i <= 20; i++) {
      if (i % 5 == 0) {
        Thread.sleep(1000);
      }
      System.out.println("Request " + i + " allowed: " + rateLimiter.allowRequest("user1"));
    }
  }
}
