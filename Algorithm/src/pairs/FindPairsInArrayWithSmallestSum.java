package pairs;

// Time  Complexity : O(k*n) where n = a.length
// Space Complexity : O(n)
public class FindPairsInArrayWithSmallestSum {

    private static void findPairsInArrayWithSmallestSum(int[] a, int[] b, int k) {
        if (k > a.length * b.length) {
            System.out.println("k pairs don't exist");
            return;
        }
        int[] temp = new int[a.length];
        while (k != 0) {
            int i = getMinIndex(a, b, temp);
            System.out.print("(" + a[i] + ", " + b[temp[i]] + ") ");
            temp[i]++;
            k--;
        }
        System.out.println();
    }

    private static int getMinIndex(int[] a, int[] b, int[] temp) {
        int index = 0, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (temp[i] < b.length && a[i] + b[temp[i]] < minSum) {
                index = i;
                minSum = a[i] + b[temp[i]];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        findPairsInArrayWithSmallestSum(new int[]{1, 2}, new int[]{3, 4}, 3);
        findPairsInArrayWithSmallestSum(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        findPairsInArrayWithSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }
}
