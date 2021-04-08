package strings;

import java.util.Arrays;

public class StringHasAllUniqueCharaceters {

    public static void main(String[] args) {
        char[] a = "ABCDEF".toCharArray();
        boolean flag = true;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "All characters are unique" : "All characters are not unique");
    }
}
