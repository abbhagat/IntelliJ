package leetcode;

public class RemoveOneElementToMakeArrayStrictlyIncreasing {

    public static boolean check(int arr[], int n) {
        int count = 0;                                  // Stores the count of numbers that are needed to be removed
        int index = -1;                                // Store the index of the element that needs to be removed
        for (int i = 1; i < n - 1; i++) {            // Traverse the range [1, N - 1]
            if (arr[i - 1] >= arr[i]) {            // If arr[i-1] is greater than or equal to arr[i]
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
        if (index == 1 || index == n - 1) {    // If only the last or the first element is removed
            return true;
        }
        if (arr[index - 1] < arr[index + 1]) {   // If a[index] is removed
            return true;
        }
        if (arr[index - 2] < arr[index]) {  // If a[index - 1] is removed
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 5, 3, 5};
        int N = arr.length;
        System.out.println(check(arr, N) ? Boolean.TRUE : Boolean.FALSE);
    }
}
