package strings;

import java.util.HashSet;
import java.util.Set;

public class GroupStringAnagrams {

    private static boolean isAnagram(String s1, String s2) {
        int[] temp = new int[128];
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                temp[s1.charAt(i)]++;
                temp[s2.charAt(i)]--;
            }
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (!set.isEmpty()) {
                System.out.println(set);
            }
            set = new HashSet<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    set.add(strs[i]);
                    set.add(strs[j]);
                }
            }
        }
    }
}
