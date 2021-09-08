package geeksforgeeks;

public class DuplicateElementsInArrayApproach2 {

    public static void main(String[] args) {
        int a[] = { -1, 2, 3, -2, 3, 6, 6 };
        for (int i = 0; i < a.length; i++) {
            int j = Math.abs(a[i]);
            if (a[j] >= 0) {
                a[j] = -a[j];
            }
            else {
                System.out.print(j + " ");
            }
        }
    }
}
