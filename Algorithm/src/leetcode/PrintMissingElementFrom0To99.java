package leetcode;

public class PrintMissingElementFrom0To99 {

    public static void main(String[] args) {
        int[] a = {88, 105, 3, 2, 200, 0, 10};
        boolean[] isPresent = new boolean[100];
        for (int x : a) {
            if (x >= 0 && x <= isPresent.length) {
                isPresent[x] = true;
            }
        }
        int i = 0;
        while (i < isPresent.length) {
            if (!isPresent[i]) {
                int j = i + 1;
                while (j < isPresent.length && !isPresent[j]) {
                    j++;
                }
                System.out.println(j == i + 1 ? i : i + "-" + (j - 1));
                i = j;
            } else {
                i++;
            }
        }
    }
}
