package pairs;

public class FindPairsWhoseProductIsLessThanAGivenNumber {

    private static int findPair(int[] a, int k) {
        int i = 0, j = a.length - 1, count = 0;
        while (i < j) {
            if (a[i] * a[j] < k) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPair(new int[]{2, 3, 5, 6}, 16));
        System.out.println(findPair(new int[]{1, 3, 4, 2, 1}, 5));
    }
}
