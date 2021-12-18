package leetcode;

public class MinSwapsToMakeStringEqual {

    private static int findMinSwaps(char[] x, char[] y) {
        if (x.length == y.length) {
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            for (int i = 0; i < x.length; i++) {
                if (x[i] != y[i]) {
                    if (x[i] == 'x') {
                        x1++;
                    } else {
                        y1++;
                    }
                    if (y[i] == 'x') {
                        x2++;
                    } else {
                        y2++;
                    }
                }
            }
            if ((x1 + x2) % 2 == 1 || (y1 + y2) % 2 == 1) {
                return -1;
            }
            return x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMinSwaps("xx".toCharArray(), "yy".toCharArray()));
        System.out.println(findMinSwaps("xy".toCharArray(), "yx".toCharArray()));
        System.out.println(findMinSwaps("xx".toCharArray(), "xy".toCharArray()));
        System.out.println(findMinSwaps("xxyyxyxyxx".toCharArray(), "xyyxyxxxyx".toCharArray()));
    }
}
