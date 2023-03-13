package cisco;

public class WiggleSort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void wiggleSort(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if ((i % 2 == 0) == (a[i] > a[i + 1])) {
                swap(a, i, i + 1);
            }
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}
