package geeksforgeeks;

public class DuplicateElementsInArray {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 2, 3, 4, 5, 6};
        int   n = a.length;
        for (int x : a) {
             int i = x % n;
             a[i] += n;
        }
        System.out.print("The repeating elements are ");
        for (int i = 0; i < n; i++) {
            if (a[i] >= n * 2) {
                System.out.print(i + " ");
            }
        }
    }
}
