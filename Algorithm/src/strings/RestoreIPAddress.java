package strings;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    private static List<String> restoreIPAddress(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() > 12) {
            return list;
        }
        restoreIPAddress(s, 3, list, "");
        return list;
    }

    private static void restoreIPAddress(String s, int dot, List<String> list, String ip) {
        if (dot == 0 || isValid(s)) {
            ip += s;
            list.add(ip);
        } else {
            for (int i = 1; i <= 3 && i < s.length(); i++) {
                String address = s.substring(0, i);
                if (isValid(address)) {
                    restoreIPAddress(s.substring(i), dot - 1, list, ip + address + ".");
                }
            }
        }
    }

    private static boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() != 1 || Integer.valueOf(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIPAddress("25525511135"));
    }
}
