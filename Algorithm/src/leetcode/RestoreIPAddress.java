package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
  Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s.
  A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros.
  For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
  Input: s = "25525511135"
  Output: ["255.255.11.135","255.255.111.35"]
  Input: s = "0000"
  Output: ["0.0.0.0"]
  Input: s = "1111"
  Output: ["1.1.1.1"]
  Input: s = "010010"
  Output: ["0.10.0.10","0.100.1.0"]
  Input: s = "101023"
  Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class RestoreIPAddress {

    private static List<String> restoreIPAddress(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() > 12) {    //In IPV4 address is of 12 digit max excluding '.'
            return list;
        }
        restoreIP(s, 3, list, "");
        return list;
    }

    private static void restoreIP(String s, int dot, List<String> list, String ip) {
        if (dot == 0 && isValid(s)) {
            ip += s;
            list.add(ip);
        } else {
            for (int i = 1; i <= 3 && i < s.length(); i++) {
                String address = s.substring(0, i);
                if (isValid(address)) {
                    restoreIP(s.substring(i), dot - 1, list, ip + address + ".");
                }
            }
        }
    }

    private static boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() != 1 || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIPAddress("25525511135"));
        System.out.println(restoreIPAddress("25525511115"));
    }
}
