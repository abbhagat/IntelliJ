package strings;

public class AllPermutationOfString {

    private static char[] a = {'A', 'B', 'C'};

    public static void permute(int start, int end) {
        if (start == end) {
            System.out.println(a);
        }
        for (int i = start; i <= end; i++) {
            swap(i, start);
            permute(start + 1, end);
            swap(i, start);
        }
    }

    private static void swap(int x, int y) {
        char t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static void main(String[] args) {
        permute(0, a.length - 1);
    }
}
