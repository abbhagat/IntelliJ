package cisco;

// Time Complexity : O(k*n) where n = a.length
// Auxiliary Space : O(n)

public class FindPairsInArrayWithSmallestSum {
    private static void findPairsInArrayWithSmallestSum(int[] a, int[] b, int k) {
        if (k > a.length * b.length) {
            System.out.print("k pairs don't exist");
            return;
        }
        int[] temp = new int[a.length];
        while (k > 0) {
            int index = getMinIndex(a, b, temp);
            System.out.print("(" + a[index] + ", " + b[temp[index]] + ") ");
            temp[index]++;
            k--;
        }
    }

    private static int getMinIndex(int[] a, int[] b, int[] temp) {
        int index = 0 , minSum = Integer.MAX_VALUE;
        // To pick next pair, traverse for all elements of a[], for every element
        // find corresponding current element in b[] and pick minimum of all formed pairs.
        for (int i = 0; i < a.length; i++) {
            if (temp[i] < b.length && a[i] + b[temp[i]] < minSum) {  // Check if current element of a[] plus element of array2 to be used gives minimum sum
                index = i;
                minSum = a[i] + b[temp[i]];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        findPairsInArrayWithSmallestSum(new int[]{1, 2}, new int[]{3, 4}, 3);
        System.out.println();
        findPairsInArrayWithSmallestSum(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        System.out.println();
        findPairsInArrayWithSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }
}
