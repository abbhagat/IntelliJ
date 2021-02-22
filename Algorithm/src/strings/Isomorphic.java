package strings;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    private static boolean isIosMorphic(char[] c1, char[] c2) {
        if (c1.length == c2.length) {
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < c1.length; i++) {
                if (map.containsKey(c1[i]) && map.get(c1[i]) != c2[i]) {
                    return false;
                }
                map.put(c1[i], c2[i]);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isIosMorphic("aab".toCharArray(), "xxy".toCharArray()) ? "IosMorphic" : "Not IosMorphic");
        System.out.println(isIosMorphic("aab".toCharArray(), "xyy".toCharArray()) ? "IosMorphic" : "Not IosMorphic");
    }
}
