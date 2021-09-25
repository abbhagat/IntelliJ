package cisco;


/*
Given an unsorted array and a position ‘P’.
Return the element that is likely to come to the given location upon sorting the array.
TC in O(n).

 */
public class FindElementPositionAfterSorting {

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 2, 7, 4, 10};
        int pos = 0;
        int num = a[pos];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == pos) {
                continue;
            }
            if (a[i] <= num) {
                index++;
            }
        }
        System.out.println("Position After Sorting " + index);
    }
}
