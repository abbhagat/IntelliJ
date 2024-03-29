package gfg;


/*
Given an unsorted array and a position ‘P’.
Return the element that is likely to come to the given location upon sorting the array.
TC in O(n).

Solution :- Iterate the array and find how many elements are less than the given position element.
 */
public class FindElementPositionAfterSorting {

    private static int findElementPositionAfterSorting(int[] a, int pos) {
        int index = 0, n = a[pos];
        for (int i = 0; i < a.length; i++) {
            if (i == pos) {
                continue;
            }
            if (a[i] <= n) {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 2, 4};
        System.out.println("Position After Sorting " + findElementPositionAfterSorting(a, 3));
        System.out.println("Position After Sorting " + findElementPositionAfterSorting(a, 4));
    }
}
