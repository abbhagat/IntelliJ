package geeks;

/*
Approach: The idea is to traverse every array element and find the highest bars on the left and right sides.
Take the smaller of two heights. The difference between the smaller height and height of the current element
is the amount of water that can be stored in this array element.
Algorithm:
Traverse the array from start to end.
For every element, traverse the array from start to that index and find the maximum height (a)
and traverse the array from the current index to end, and find the maximum height (b).
The amount of water that will be stored in this column is min(a,b) – array[i], add this value to the total amount of water stored
Print the total amount of water stored.

Instead of maintaining two arrays of size n for storing the left and a right max of each element,
maintain two variables to store the maximum till that point.
Since water trapped at any element = min(max_left, max_right) – arr[i].
Calculate water trapped on smaller elements out of A[low] and A[high] first and move the pointers till low doesn’t cross high.
 */
public class TrappingRainWater {

    private static int findWater(int[] a, int low, int high) {
        int result = 0;
        int max_left = 0, max_right = 0; // maximum element on left and right
        while (low <= high) {
            if (a[low] < a[high]) {
                if (max_left < a[low]) {
                    max_left = a[low];  // update max in left
                } else {
                    result += max_left - a[low];  // water on curr element = max - curr
                }
                low++;
            } else {
                if (max_right < a[high]) {
                    max_right = a[high];  // update right maximum
                } else {
                    result += max_right - a[high];  // water on curr element = max - curr
                }
                high--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 0, 2, 0, 4};
        System.out.print(findWater(a, 0, a.length - 1));
    }
}
