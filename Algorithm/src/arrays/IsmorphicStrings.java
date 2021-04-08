package goldmansach;

import java.util.HashMap;
import java.util.Map;

public class IsmorphicStrings {

    private static boolean isIsomorphic(char[] c1, char[] c2) {

        if (c1.length == c2.length) {
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < c1.length; i++) {
                if (null != map.get(c1[i]) && map.get(c1[i]) != c2[i]) {
                    return false;
                }
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aab".toCharArray(), "xxy".toCharArray()) ? "Isomorphic" : "Not Isomorphic");
    }
}
