package gfg;

import java.util.Arrays;
import java.util.List;

public class ThrottlingGateway {

  public static long droppedRequests(List<Integer> requestTime) {
    long dropped = 0;
    for (int i = 0; i < requestTime.size(); i++) {
      if (i >= 3 && requestTime.get(i) == requestTime.get(i - 3)) {
        dropped++;  // If the current request has the same timestamp as the request 3 positions before it, then there are already 3 requests in that second.
      } else if (i >= 20 && requestTime.get(i) - requestTime.get(i - 20) < 10) {
        dropped++; // If the current request and the request 20 positions before it are less than 10 seconds apart, then this is the 21st request within a 10-second window.
      } else if (i >= 60 && requestTime.get(i) - requestTime.get(i - 60) < 60) {  // If the current request and the request 60 positions before it are less than 60 seconds apart, then this is the 61st request within a 60-second window.
        dropped++; // If the current request and the request 60 positions before it are less than 60 seconds apart, then this is the 61st request within a 60-second window.
      }
    }
    return dropped;
  }

  public static void main(String[] args) {
    System.out.println(droppedRequests(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11)));
    System.out.println(droppedRequests(Arrays.asList(1, 1, 1, 1, 2)));
  }
}
