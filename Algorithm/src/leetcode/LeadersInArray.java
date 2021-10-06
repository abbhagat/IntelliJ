package leetcode;

/**
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 * Let the input array be arr[] and size of the array be size.
 */
public class LeadersInArray {

    public static void main(String[] args) {
        int[] a = {16, 17, 4, 3, 5, 2};
        int max = a[a.length - 1];
        System.out.print(max + " ");
        for (int i = a.length - 2; i >= 0; i--) {
            if (max < a[i]) {
                System.out.print(a[i] + " ");
                max = a[i];
            }
        }
    }
}