package geeksforgeeks;

public class FinalAccountBalSolutionAMEX {

    public static int solution(int[] A, String[] D) {
        if(A.length == 0 || D.length == 0){
            return 0;
        }
        int balance = A[0];
        String prevMonth = D[0].substring(5, 7);
        int cardPaymentInAMonth = balance < 0 ? 1 : 0;
        int totalAmtPaidThroughCard = Math.min(balance, 0);
        int waiver = 0;
        for (int i = 1; i < D.length; i++) {
            balance += A[i];
            if (prevMonth.equals(D[0].substring(5, 7)) && A[i] < 0) {
                cardPaymentInAMonth++;
                totalAmtPaidThroughCard += Math.abs(A[i]);
            } else {
                cardPaymentInAMonth = totalAmtPaidThroughCard = 0;
            }
            if (cardPaymentInAMonth == 3 && totalAmtPaidThroughCard >= 100) {
                waiver++;
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
