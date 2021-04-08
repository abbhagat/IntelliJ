package strings;

import java.util.ArrayList;
import java.util.List;

public class GroupStringAnagrams {

    static boolean isAnagram(String s1, String s2) {
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
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        String[] s = { "Java", "avaJ", "anagram", "xyz", "pqr", "zxy", "raanagm" };
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (isAnagram(s[i], s[j])) {
                    System.out.println(s[i] + " is anagram of " + s[j]);
                    al.add(s[i]);
                    al.add(s[j]);
                }
            }
        }
        System.out.println(al);
    }
}
