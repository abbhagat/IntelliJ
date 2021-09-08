package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfArrayNum {

    public List<List<Integer>> permute(int[] nums) {
        String s = "";
        for (int x : nums) {
            s += x;
        }
        List<List<String>> list = new ArrayList<>();
        permutation(s.toCharArray(), 0, s.length() - 1, list);
        System.out.println(list);
        return null;
    }

    public void permutation(char[] a, int start, int end, List<List<String>> list) {
        if (start == end) {
            List<String> al = new ArrayList<>();
            for (char x : a) {
                al.add("" + x);
            }
            list.add(al);
        } else {
            for (int i = start; i <= end; i++) {
                swap(a, i, start);
                permutation(a, start + 1, end, list);
                swap(a, i, start);
            }
        }
    }

    private static void swap(char[] a, int x, int y) {
        char c = a[x];
        a[x] = a[y];
        a[y] = c;
    }

    public static void main(String[] args) {

    }
}
