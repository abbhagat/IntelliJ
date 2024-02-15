package jpmorgan;

import java.util.ArrayList;
import java.util.List;

public class ArraySplitInChunks {

    private static List<int[]> splitArray(int[] a, int splitSize) {
        int n = a.length;
        int remainingSize = n % splitSize;
        List<int[]> list = new ArrayList<>();
        int i;
        for (i = 0; i < a.length - remainingSize; i += splitSize) {
            int[] t = new int[splitSize];
            System.arraycopy(a, i, t, 0, splitSize);
            list.add(t);
        }
        if (remainingSize > 0) {
            int[] t = new int[remainingSize];
            System.arraycopy(a, i, t, 0, remainingSize);
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 2));
        System.out.println(splitArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 3));
    }
}
