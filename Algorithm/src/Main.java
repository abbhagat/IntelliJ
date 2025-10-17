import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> restoreIPAddress(String s) {
        List<String> list = new ArrayList<>();
        if(s.length() > 12) {
            return list;
        }
        restoreIPAddress(3, s, "", list);
        return list;
    }

    private static void restoreIPAddress(int dot, String s, String ip, List<String> list) {

        if (dot == 0 && isValid(s)) {
            ip += s;
            list.add(ip);
            return;
        }
        for(int i = 1; i <= 3 && i < s.length(); i++) {
            String address = s.substring(0, i);
            if(isValid(address)) {
                restoreIPAddress(dot - 1, s.substring(i), ip + address + ".", list);
            }
        }

    }

    private static boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() != 1) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIPAddress("25525511135"));
        System.out.println(restoreIPAddress("25525511115"));
    }
}
