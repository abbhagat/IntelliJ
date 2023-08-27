package leetcode;

// Time  Complexity: O(n)
// Space Complexity: O(n)

public class PrintMissingRangeFrom0To99 {

    private static void printMissingRange(int[] a, int start, int end) {
        boolean[] isPresent = new boolean[end + 2];
        isPresent[end + 1] = true;
        for (int x : a) {
            if (x >= start && x <= end) {
                isPresent[x] = true;
            }
        }
        int index = -1, i;
        for (i = start; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                index = index == -1 ? i : index;
            } else {
                if (index != -1) {
                    System.out.println(i == index + 1 ? index : index + "-" + (i - 1));
                    index = -1;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMissingRange(new int[]{2, 3, 4, 6, 9, 10}, 0, 10);
        printMissingRange(new int[]{88, -1, 105, 3, 2, 200, 0, 10}, 0, 99);
        printMissingRange(new int[]{88, -1, 105, 3, 2, 200, 0, 10}, 10, 90);
        printMissingRange(new int[]{88, -1, 105, 3, 2, 200, 0, 10}, 11, 90);
    }
}
