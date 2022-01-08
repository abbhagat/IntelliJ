package leetcode;

public class ValidateIPAddress {

    private static boolean isValidIPv4(String ipv4) {
        int count = 0;
        for (char x : ipv4.toCharArray()) {
            if (x == '.') {
                count++;
            }
        }
        if (count != 3) {
            return false;
        }
        for (String s : ipv4.split(".")) {
            if (s.length() == 0 || s.length() > 3) {
                return false;
            }
            if (s.charAt(0) == '0' && s.length() != 1) {
                return false;
            }
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            if (Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIPv6(String ipv6) {
        int count = 0;
        for (char x : ipv6.toCharArray()) {
            if (x == ':') {
                count++;
            }
        }
        if (count != 7) {
            return false;
        }
        String hexDigits = "0123456789abcdefABCDEF";
        for (String s : ipv6.split(":")) {
            if (s.length() == 0 || s.length() > 4) {
                return false;
            }
            for (char c : s.toCharArray()) {
                if (hexDigits.indexOf(c) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidIPv4("204.120.0.15") ? "Valid IPv4" : "Invalid IPv4");
        System.out.println(isValidIPv6("2001:db8:3333:4444:5555:6666:7777:8888") ? "Valid IPv6" : "Invalid IPv6");
    }
}
