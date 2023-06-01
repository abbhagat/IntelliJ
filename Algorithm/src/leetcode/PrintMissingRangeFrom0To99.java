package leetcode;

// Time  Complexity: O(n)
// Space Complexity: O(n)

public class PrintMissingRangeFrom0To99 {

    public static void main(String[] args) {
        int[] a = {88, -1, 105, 3, 2, 200, 0, 10};
        boolean[] isPresent = new boolean[100];
        for (int x : a) {
            if (x >= 0 && x <= isPresent.length) {
                isPresent[x] = true;
            }
        }
        int index = -1, i;
        for (i = 0; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                index = index == -1 ? i : index;
            }
            if(index != -1 && isPresent[i]) {
                System.out.println(i == index + 1 ? index : index + "-" + (i - 1));
                index = -1;
            }
        }
        if(index != -1 && i == isPresent.length && !isPresent[i - 1]) {
            System.out.println(i == index + 1 ? index : index + "-" + (i - 1));
        }
    }
}
