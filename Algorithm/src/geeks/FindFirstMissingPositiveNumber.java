package geeks;

/**
 * Traverse the array, Ignore the elements which are greater than n and less than 1.
 * While traversing check a[i]!=a[a[i]-1] if this condition hold true or not .
 * If the above condition is true then swap a[i], a[a[i] – 1]  && swap until a[i] != a[a[i] – 1]  condition will fail .
 * Traverse the array and check whether a[i] != i + 1 then return i + 1.
 * If all are equal to its index then return n+1.
 * O(n)
 */
public class FindFirstMissingPositiveNumber {

    public static int firstMissingPositive(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            while (a[i] >= 1 && a[i] <= n && a[i] != a[a[i] - 1]) {  // Loop to check boundary condition and for swapping
                int temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
            }
        }
        // Finding which index has value less than n
        for (int i = 0; i < n; i++) {
            if (a[i] != i + 1) {
                return (i + 1);
            }
        }
        return (n + 1);   // If array has values from 1 to n
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2, 3, -7, 6, 8, 1, -10, 15}));
    }
}
