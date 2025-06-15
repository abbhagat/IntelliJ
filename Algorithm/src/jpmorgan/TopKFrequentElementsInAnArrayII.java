package jpmorgan;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static util.CommonUtils.swap;

/**
Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the temp
(According to their decreasing frequency) every time a new number is read.
We basically need to print temp k numbers sorted by frequency when input stream has included k distinct elements,
else need to print all distinct elements sorted by frequency.
Examples:
Input : arr[] = {5, 2, 1, 3, 2} k = 4
Output: 5 2 5 1 2 5 1 2 3 5 2 1 3 5
After reading 5, there is only one element 5 whose frequency is max till now. so print 5.
After reading 2, we will have two elements 2 and 5 with the same frequency.
As 2 is smaller than 5 but their frequency is the same, so we will print 2 5.
After reading 1, we will have 3 elements 1, 2 and 5 with the same frequency, so print 1 2 5.
Similarly, after reading 3, print 1 2 3 5
After reading last element 2 since 2 has already occurred, so we have now a
frequency of 2 as 2. So we keep 2 at the temp and then rest of the element
with the same frequency in sorted order. So print, 2 1 3 5.
Input: arr[] = {5, 2, 1, 3, 4} k = 4
Output: 5 2 5 1 2 5 1 2 3 5 1 2 3 4
Explanation:
After reading 5, there is only one element 5 whose frequency is max till now so print 5.
After reading 2, we will have two elements 2 and 5 with the same frequency.
As 2, is smaller than 5 but their frequency is the same, so we will print 2 5.
After reading 1, we will have 3 elements 1, 2 and 5 with the same frequency, so print 1 2 5.
Similarly, after reading 3, print 1 2 3 5
After reading last element 4; All the elements have the same frequency So print, 1 2 3 4
Approach: The idea is to store the temp k elements with maximum frequency.
To store them a vector or an array can be used. To keep track of the frequency of elements creates a HashMap to store element-frequency pairs.
Given a stream of numbers, when a new element appears in the stream update the frequency of that element in HashMap
and put that element at the end of the list of K numbers (total k+1 elements) now compare adjacent elements of the list
and swap if higher frequency element is stored next to it.
Algorithm:
Create a Hashmap and an array of k + 1 length.
Traverse the input array from start to end.
Insert the element at k+1 position of the array, and update the frequency of that element in HashMap.
Now, iterate from the position of element to zero.
For very element, compare the frequency and swap if a higher frequency element is stored next to it,
if the frequency is the same then the swap is the next element is greater.
print the temp k element in each traversal of the original array.
*/

// Time  Complexity: O(n * k) In each traversal the temp array of size k is traversed, So the time Complexity is O(n * k).
// Space Complexity: O(n)     To store the elements in HashMap O(n) space is required.
public class TopKFrequentElementsInAnArrayII {

    private static void topKFrequent(Stream<Integer> intStream, int k) {
        int[] temp = new int[k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= k; i++) {
            map.put(i, 0);
        }
        intStream.forEach(n -> {
            map.put(n, map.getOrDefault(n, 0) + 1);
            temp[k] = n;
            for (int i = search(temp, n) - 1; i >= 0; i--) {
                int x = map.get(temp[i]);
                int y = map.get(temp[i + 1]);
                if (x < y || (x == y && temp[i] > temp[i + 1])) {
                    swap(temp, i, i + 1);
                } else {
                    break;
                }
            }
/*    Replace the below for loop with this for k = 1
            if (temp[0] != 0) {
                System.out.print(temp[0] + " ");
            }
*/
            for (int i = 0; i < k && temp[i] != 0; i++) {  // for(int i = temp.length - 2; i >= k - 1; i--) {
                System.out.print(temp[i] + " ");
            }
        });
    }

    private static int search(int[] temp, int n) {
        for (int i = 0; i < temp.length; i++)
            if (temp[i] == n) {
                return i;
            }
        return -1;
    }

    public static void main(String[] args) {
        topKFrequent(Stream.of(5, 2, 1, 3, 2), 2);
        System.out.println();
        topKFrequent(Stream.of(5, 2, 1, 3, 4), 4);
        System.out.println();
        topKFrequent(Stream.of(5, 2, 5, 5, 2, 2, 2, 4, 2, 3, 5, 5, 2, 5, 5, 2, 3, 5, 2, 5), 1);
    }
}
