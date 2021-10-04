package leetcode;

public class PrintMissingElementFrom0To99 {

    public static void main(String[] args) {
        int[] a = {88, 105, 3, 2, 200, 0, 10};
        boolean[] b = new boolean[100];
        for (int x : a) {
            if (x >= 0 && x < 100) {
                b[x] = true;
            }
        }

        for (int i = 0; i < b.length;) {
            if (!b[i]) {
                int j = i + 1;
                while (j < b.length && !b[j]) {
                    j++;
                }
                System.out.println(j == (i + 1) ? i : i + "-" + (j - 1));
                i = j;
            } else {
                i++;
            }
        }
    }
}
