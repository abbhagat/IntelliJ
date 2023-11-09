package searching;

public class FindFirstMissingPositiveNumber {

    private static int firstMissingPositive(int[] a) {
        int n = a.length;
        boolean[] isPresent = new boolean[n + 1];
        for (int x : a) {
            if (x > 0 && x <= n)
                isPresent[x] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!isPresent[i]) {
                return i;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 3, 4}));
        System.out.println(firstMissingPositive(new int[]{2, 3, -7, 6, 8, 1, -10, 15}));
    }
}
