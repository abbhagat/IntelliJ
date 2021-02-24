package strings;

public class AllPermutationOfString {

    private static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

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
        permutation("ABC","");
    }
}
