package adobe;

import java.util.Arrays;

public class NumOfToysCanBePurchasedWithAmountK {

    public static void main(String[] args) {
        int[] cost = {1, 12, 5, 111, 200, 1000, 10, 9, 12, 15};
        int k = 50, count = 0, sum = 0;
        Arrays.sort(cost);
        for (int x : cost) {
            sum += x;
            if (sum <= k) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
