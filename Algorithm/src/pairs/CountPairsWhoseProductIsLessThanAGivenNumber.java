package pairs;

public class CountPairsWhoseProductIsLessThanAGivenNumber {

    private static int findPair(int[] a, int n) {
        int i = 0, j = a.length - 1, count = 0;
        while (i < j) {
            if (a[i] * a[j] < n) {
                count += j - i;
            }
            int k = a[i] * a[j] < n ? i++ : j--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPair(new int[]{1, 2, 3}, 10));
        System.out.println(findPair(new int[]{2, 3, 5, 6}, 16));
        System.out.println(findPair(new int[]{1, 3, 4, 2, 1}, 5));
    }
}
