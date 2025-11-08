package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ListOfAllPhoneNumOfCaseInsentiveStrings {

    public static void main(String[] args) {

        Map<String, List<Integer>> chm = new ConcurrentHashMap<>();
        String[] str = {"ABc", "bcd", "cda", "abc"};
        int[] a = {123, 456, 678, 8910};
        List<Integer> al;
        for (int i = 0; i < str.length; i++) {
            if (chm.get(str[i].toLowerCase()) == null) {
                al = new ArrayList<>();
                al.add(a[i]);
                chm.put(str[i].toLowerCase(), al);
            } else {
                al = chm.get(str[i].toLowerCase());
                al.add(a[i]);
            }
        }
        String x = "abc";
        if (chm.get(x.toLowerCase()) == null) {
            System.out.println(x + " 0");
        } else {
            System.out.println(x + " " + chm.get(x.toLowerCase()));
        }
    }
}
