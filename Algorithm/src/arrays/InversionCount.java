package arrays;

public class InversionCount {
    static int[] a = { 10, 15, 8, 4, 2, 1 };
    static int count;

    static void countInversion(int i, int j, int k) {
        if (a[i] > a[j] && a[j] > a[k]) {
            System.out.println(a[i] + " " + a[j] + " " + a[k]);
            count++;
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        for (i = 0; i < a.length && j + 2 < a.length; i++, j++) {
            countInversion(j, j + 1, j + 2);
        }
        System.out.println("Total Inversion Count :" + count);
    }
}
