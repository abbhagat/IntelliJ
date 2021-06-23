package geeks;

import java.util.HashMap;
import java.util.Map;

public class FindCycleInASeqOfNum {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[] str = { "2", "0", "5", "3", "1", "5", "3", "1", "5", "3", "1" };
        String s = "";
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].equals(str[j])) {
                    if (map.get(str[j]) == null || map.get(s) == null) {
                        s += str[i];
                        map.put(s,1);
                    }
                    break;
                }
            }
        }
        System.out.println(s);
    }
}
