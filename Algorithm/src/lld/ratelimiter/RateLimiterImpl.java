package lld.ratelimiter;

public class RateLimiterImpl {

  public static void main(String[] args) throws InterruptedException {
    IRateLimiter rateLimiter = new RateLimiter(5, 1);
    for (int i = 1; i <= 10; i++) {
      if (i == 5 || i == 9) {
        Thread.sleep(2000);
      }
      System.out.println("Request " + i + " allowed: " + rateLimiter.allowRequest("user1"));
    }
  }
}
