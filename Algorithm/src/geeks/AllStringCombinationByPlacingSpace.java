package geeks;

import java.util.ArrayList;
import java.util.List;

/*
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.

Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
 */
public class AllStringCombinationByPlacingSpace {

    private static List<String> spaceString(String str) {
        List<String> al = new ArrayList<>();
        if (str.length() == 1) {
            al.add(str);
            return al;
        }
        List<String> list = spaceString(str.substring(1));
        for (int i = 0; i < list.size(); i++) {
            al.add(str.charAt(0) + list.get(i));
            al.add(str.charAt(0) + " " + list.get(i));
        }
        return al;
    }

    public static void main(String args[]) {
        List<String> patterns = spaceString("ABC");
        for (String s : patterns) {
            System.out.println(s);
        }
    }
}
