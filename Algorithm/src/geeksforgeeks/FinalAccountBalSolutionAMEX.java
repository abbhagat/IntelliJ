package geeksforgeeks;

import java.util.*;

public class FinalAccountBalSolutionAMEX {

  public static int solution(int[] A, String[] D) {
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      List<Integer> list = map.containsKey(D[i].substring(5, 7)) ? map.get(D[i].substring(5, 7)) : new ArrayList<>();
      list.add(A[i]);
      map.put(D[i].substring(5, 7), list);
    }
    int waiver = 0, balance = 0;
    Set<Map.Entry<String, List<Integer>>> set = map.entrySet();
    for (Map.Entry<String, List<Integer>> m : set) {
      int cardPaymentInAMonth = 0, totalAmtPaidThroughCard = 0;
      for (int bal : m.getValue()) {
        balance += bal;
        if (bal < 0) {
          totalAmtPaidThroughCard += Math.abs(bal);
          cardPaymentInAMonth++;
        }
      }
      if (cardPaymentInAMonth >= 3 && totalAmtPaidThroughCard >= 100) {
        waiver += 1;
      }
    }
    return balance - (12 - waiver) * 5;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{100, 100, 100, -10}, new String[]{"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"}));
    System.out.println(solution(new int[]{180, -50, -25, -25}, new String[]{"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"}));
    System.out.println(solution(new int[]{1, -1, -0, -105, 1}, new String[]{"2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12"}));
    System.out.println(solution(new int[]{100, 100, -10, -20, -30}, new String[]{"2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08"}));
  }
}

/*
        AtomicInteger waiver = new AtomicInteger();
        AtomicInteger balance = new AtomicInteger();
        Set<Map.Entry<String, List<Integer>>> set = map.entrySet();
        map.forEach((k,v) ->{
            int cardPaymentInAMonth = 0, totalAmtPaidThroughCard = 0;
            for (int bal : v) {
                balance.addAndGet(bal);
                if (bal < 0) {
                    totalAmtPaidThroughCard += Math.abs(bal);
                    cardPaymentInAMonth++;
                }
            }
            if (cardPaymentInAMonth >= 3 && totalAmtPaidThroughCard >= 100) {
                waiver.getAndIncrement();
            }
        });
        return balance.get() - (12 - waiver.get()) * 5;
 */