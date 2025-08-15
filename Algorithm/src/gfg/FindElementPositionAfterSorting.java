package gfg;

/**
Given an unsorted array and a position ‘P’.
Return the element that is likely to come to the given location upon sorting the array.
Solution: Iterate the array and find how many elements are less than the given position element.
*/
// Time Complexity: O(n)
public class FindElementPositionAfterSorting {

    private static int findElementPositionAfterSorting(int[] a, int pos) {
        int count = 0, n = a[pos];
        for (int i = 0; i < a.length; i++) {
            if (i == pos) {
                continue;
            }
            if (a[i] <= n) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 2, 4};
        System.out.println("Position After Sorting " + findElementPositionAfterSorting(a, 3));
        System.out.println("Position After Sorting " + findElementPositionAfterSorting(a, 4));
    }
}
