package adobe;

/**
 *
 * There is a one-dimensional garden on the x-axis.
 * The garden starts at the point 0 and ends at the point n. (i.e., the length of the garden is n).
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed)
 * means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open
 * Input: n = 5, a = [3,4,1,1,0,0]
 * Output: 1
 * Explanation:
 * The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 * Example 2:
 * Input: n = 3, a = [0,0,0,0]
 * Output: -1
 * Explanation: Even if you activate all the four taps you cannot water the whole garden.
 */
public class MinTapsToWaterGarden {

  public static int minTaps(int[] a, int n) {
    int min = 0, max = 0, count = 0; // Initialize variables to keep track of the minimum and maximum reach, and the number of taps used.
    while (max < n) { // Continue looping until we cover the entire range from 0 to n.
      for (int i = 0; i < a.length; i++) {
        // Check if tap i can cover the current minimum position (min) and reach the current maximum position (max).
        if (i - a[i] <= min && i + a[i] >= max) {
          max = i + a[i]; // Update the maximum reach if this tap can cover the current range.
        }
      }
      if (max == min) {
        return -1;       // If max is not updated in this loop, it means we can't extend the reach further. Return -1 as it's not possible.
      }
      count++;       // Increment the count of taps used.
      min = max;    // Update the minimum reach to the newly reached maximum position.
    }
    return count; // Return the count of taps used to cover the entire range.
  }

  public static void main(String[] args) {
    System.out.println(minTaps(new int[]{3, 4, 1, 1, 0, 0}, 5));
  }
}
