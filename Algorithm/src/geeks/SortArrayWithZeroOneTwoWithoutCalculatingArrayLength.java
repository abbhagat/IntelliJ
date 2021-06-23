package geeks;

public class SortArrayWithZeroOneTwoWithoutCalculatingArrayLength {

    private static int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

    private static void swap(int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void sort(int startIdx, int value) {
        int i = startIdx;
        int j = startIdx;
        while (true) {
            try {
                if (a[i] == value) {
                    swap(i, j);
                    j++;
                }
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        sort(0, 0);
        int k = 0;
        for (int x : a) {
            if (x == 0) {
                k++;
            } else {
                break;
            }
        }
        sort(k, 1);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
