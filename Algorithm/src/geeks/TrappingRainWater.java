package geeks;

/**
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
Since water trapped at any element = min(maxLeft, maxRight) – arr[i].
Calculate water trapped on smaller elements out of A[low] and A[high] first and move the pointers till low doesn’t cross high.
*/

// Time Complexity: O(n)
// Auxiliary Space: O(1)

public class TrappingRainWater {
    private static int findWater(int[] a) {
        int waterTrapped = 0, maxLeft = 0, maxRight = 0, low = 0, high = a.length - 1;
        while (low <= high) {
            if (a[low] < a[high]) {
                if (maxLeft < a[low]) {
                    maxLeft = a[low];
                } else {
                    waterTrapped += maxLeft - a[low];
                }
                low++;
            } else {
                if (maxRight < a[high]) {
                    maxRight = a[high];
                } else {
                    waterTrapped += maxRight - a[high];
                }
                high--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        System.out.println(findWater(new int[]{2, 5, 8, 9, 4}));
        System.out.println(findWater(new int[]{3, 0, 2, 0, 4}));
    }
}
