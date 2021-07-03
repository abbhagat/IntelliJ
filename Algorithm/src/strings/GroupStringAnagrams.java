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
        List<List<String>> list = new ArrayList<>();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        label:
        for (int i = 0; i < strs.length; i++) {
            List<String> al = new ArrayList<>();
            if (!list.isEmpty()) {
                for (List k : list) {
                    if (k.contains(strs[i])) {
                        continue label;
                    }
                }
            }
            al.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    if(!al.contains(strs[i]))
                    al.add(strs[i]);
                    al.add(strs[j]);
                }
            }
            if (!al.isEmpty()) {
                list.add(al);
            }
        }
        System.out.println(list);
    }
}
