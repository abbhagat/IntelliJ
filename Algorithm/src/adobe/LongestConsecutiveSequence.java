package adobe;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.max;

public class LongestConsecutiveSequence {

    private static int longestConsecutiveSequence(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        int max = 1, count, i, j;
        for (int x : a) {
            i = x - 1;
            j = x + 1;
            count = 1;
            while (set.contains(i)) {
                count++;
                set.remove(i);
                i--;
            }
            while (set.contains(j)) {
                count++;
                set.remove(j);
                j++;
            }
            max = max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{100, 4, 20, 1, 3, 2}));
    }
}
