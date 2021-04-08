package sorting;

public class MissNum {
    public static void main(String[] args) {

        int[] a = { 9, 7, 3, 4, 10, 1, 2, 8, 6 };
        int min = a[0];
        int max = a[0];
        int n = a.length + 1;
        int sum1 = 0, sum2;
        for (int i : a) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
            sum1 += i;
        }
        sum2 = ((min + max) * n) / 2;
        System.out.println("Missing Num : " + (sum2 - sum1));
    }
}
