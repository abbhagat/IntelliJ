package geeksforgeeks;

// Time Complexity :- O(n * n!)
public class AllPermutationOfArrayNum {

    private static void permute(int[] a) {
        char[] c = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = (char) (a[i] + '0');
        }
        permutation(c, 0, c.length - 1);
    }

    private static void permutation(char[] c, int start, int end) {
        if (start == end) {
            System.out.println(c);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(c, i, start);
            permutation(c, start + 1, end);
            swap(c, i, start);
        }
    }

    private static void swap(char[] a, int x, int y) {
        char c = a[x];
        a[x] = a[y];
        a[y] = c;
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
        Double d = 1000d;
        System.out.println("Normal value :" + d);
        System.out.println("Without decimal points :" + d.longValue());
        System.out.println(String.valueOf(Double.parseDouble("1.0")).split("\\.")[0]);
    }
}
