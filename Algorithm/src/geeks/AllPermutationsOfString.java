package geeks;

public class AllPermutationsOfString {

    //private static char[] a = {'A', 'E', 'I','O', 'U'};
    private static char[] a = {'A', 'B', 'C'};
    private static int count;

    private static void permute(int start, int end) {
        if (start == end) {
            count++;
            System.out.println(a);
        }
        for (int i = start; i <= end; i++) {
            swap(i, start);
            permute(start + 1, end);
            swap(i, start);
        }
    }

    private static void swap(int x, int y) {
        char c = a[x];
        a[x] = a[y];
        a[y] = c;
    }

    public static void main(String[] args) {
        permute(0, a.length - 1);
        System.out.println(count);
    }
}
