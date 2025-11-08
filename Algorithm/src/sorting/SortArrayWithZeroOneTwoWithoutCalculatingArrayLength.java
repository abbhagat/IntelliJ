package sorting;

import static util.CommonUtils.printArray;

public class SortArrayWithZeroOneTwoWithoutCalculatingArrayLength {

    private static void sort(int[] a) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; true; i++) {
            try {
                switch (a[i]) {
                    case 0:
                        c0++;
                        break;
                    case 1:
                        c1++;
                        break;
                    case 2:
                        c2++;
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        for (int i = 0; i < c0 + c1 + c2; i++) {
            a[i] = (i < c0) ? 0 : i < (c0 + c1) ? 1 : 2;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort(a);
        printArray(a);
    }
}
