package leetcode;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {

    public static boolean check(int a[]) {
        int count = 0;                               // Stores the count of numbers that are needed to be removed
        int index = -1, n = a.length - 1;           // Store the index of the element that needs to be removed
        for (int i = 1; i < n; i++) {              // Traverse the range [1, N - 1]
            if (a[i - 1] >= a[i]) {               // If a[i-1] is greater than or equal to a[i]
                count++;                         // Increment the count by 1
                index = i;                      // Update index
            }
        }
        if (count > 1) {                          // If count is greater than one
            return false;
        }
        if (count == 0) {                        // If no element is removed
            return true;
        }
        if (index == 1 || index == n) {        // If only the last or the first element is removed
            System.out.println(a[index]);
            return true;
        }
        if (a[index - 1] < a[index + 1]) {   // If a[index] is removed
            System.out.println(a[index]);
            return true;
        }
        if (a[index - 2] < a[index]) {  // If a[index - 1] is removed
            System.out.println(a[index]);
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 5, 3, 5};
        System.out.println(check(a) ? Boolean.TRUE : Boolean.FALSE);
    }
}
