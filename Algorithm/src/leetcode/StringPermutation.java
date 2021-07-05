package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    private static void permute(char[] c, int start, int end, List<String> list, boolean flag, String s1, String s2) {
        if (start == end) {
            flag = s2.contains(new String(c));
        }
        else{
            for (int i = start; i <= end; i++) {
                swap(c, i, start);
                permute(c, start + 1, end, list, flag, s1, s2);
                swap(c, i, start);
            }
        }
    }

    private static void swap(char[] a, int x, int y) {
        char t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        boolean flag = false;
        permute(s1.toCharArray(), 0, s1.length() - 1, list, flag, s1, s2);
        permute(s1.toCharArray(), 0, s1.length() - 1, list, flag, s1, s2);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("prosperity", "properties"));
    }
}
