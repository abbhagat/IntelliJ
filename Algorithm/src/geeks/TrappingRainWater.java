package geeks;

/*
Approach: At every index, The amount of rainwater stored is the difference between current index height and a minimum of left max height and right max height
Algorithm :
Take two pointers low and high. Initialize low to the starting index 0 and high to the last index n-1
Since low is the first element, left_max would be 0, and right max for high would be 0
While low <= high , iterate the array. We have two possible conditions
Condition1 : left_max <= right max
Consider Element at index low
Since we have traversed all elements to the left of low, left_max is known
For the right max of low, We can say that the right max would  always be >= current r_max here
So, min(left_max,right_max) would always equal to left_max in this case
Increment low
Condition2 : left_max >  right max
Consider Element at index high
Since we have traversed all elements to the right of high, right_max is known
For the left max of low, We can say that the left max would  always be >= current l_max here
So, min(left_max,right_max) would always equal to right_max in this case decrement high
Time Complexity: O(n)
Auxiliary Space: O(1)
 */
public class TrappingRainWater {

    private static int maxWater(int[] a, int low, int high) {
        int l_max = 0, r_max = 0;     // To store Left max and high max for two pointers low and high
        int result = 0;              // To store the total amount of rain water trapped
        while (low <= high) {
            if (l_max <= r_max) {
                result += Math.max(0, l_max - a[low]);  // Add the difference between current value and low max at index low
                l_max = Math.max(l_max, a[low]);  // Update low max
                low++;  // Update low pointer
            } else {  // We need check for minimum of low and high max for each element
                result += Math.max(0, r_max - a[high]);  // Add the difference between current value and high max at index high
                r_max = Math.max(r_max, a[high]);  // Update high max
                high--;  // Update high pointer
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 2, 0, 4};
        System.out.print(maxWater(a, 0, a.length - 1));
    }
}
