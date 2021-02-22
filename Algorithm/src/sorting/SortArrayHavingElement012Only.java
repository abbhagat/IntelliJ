package sorting;

public class SortArrayHavingElement012Only {

    private static int[] a = {1, 2, 1, 2, 0, 1, 0, 2, 0, 0, 1, 1, 0};

    private static void move(int start, int value) {
        int i = start;
        int j = start;
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

    private static void swap(int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static void main(String[] args) {
        move(0, 0);
        int index = 0;
        for (int x : a) {
            if (x == 0) {
                index++;
            } else {
                break;
            }
        }
        move(index + 1, 1);
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
