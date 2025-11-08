package adobe;

import java.util.Arrays;

// Time Complexity : n log(n)
public class NumOfToysCanBePurchasedWithAmountK {

    private static int numOfToys(int[] cost, int k) {
        int count = 0, sum = 0;
        Arrays.sort(cost);
        for (int x : cost) {
            sum += x;
            if (sum <= k) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numOfToys(new int[]{1, 12, 5, 111, 200, 1000, 10, 9, 12, 15}, 50));
        System.out.println(numOfToys(new int[]{1, 12, 5, 111, 200, 1000, 10, 9, 12, 15}, 90));
    }
}
