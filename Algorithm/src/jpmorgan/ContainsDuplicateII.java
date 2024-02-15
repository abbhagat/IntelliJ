package jpmorgan;

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array
such that nums[i] == nums[j] and abs(i - j) <= k
 */
public class ContainsDuplicateII {

    private static boolean containsNearbyDuplicate(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (!set.add(a[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(a[i - k]);
            }
        }
        return false;
    }

    private static boolean containsDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int n : a)
            if (!set.add(n)) {
                return true;
            }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
