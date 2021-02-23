package arrays;

public class CountWaysToDisplay5 {

    private static int count = 0;

    private static void countUniqueWays(String prefix, int n, int itr) {
        if (n == 0) {
            System.out.println(prefix);
            count++;
        }
        for (int i = 1; i <= n && i <= itr; i++) {
            String newPrefix = prefix + (prefix == "" ? prefix : "+") + i;
            countUniqueWays(newPrefix, n - i, i);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        countUniqueWays("", n, n);
        System.out.println(count);
    }
}
