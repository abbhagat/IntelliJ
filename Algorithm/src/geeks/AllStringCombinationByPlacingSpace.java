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
        for (String s : list) {
            al.add(str.charAt(0) + s);
            al.add(str.charAt(0) + " " + s);
        }
        return al;
    }

    public static void main(String args[]) {
        System.out.println(spaceString("ABC"));
    }
}
