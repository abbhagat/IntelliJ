package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s.
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Input: s = "25525511135" Output: ["255.255.11.135","255.255.111.35"]
 * Input: s = "0000"        Output: ["0.0.0.0"]
 * Input: s = "1111"        Output: ["1.1.1.1"]
 * Input: s = "010010"      Output: ["0.10.0.10","0.100.1.0"]
 * Input: s = "101023"      Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */

// Time Complexity: O(2^n) where n is the length of the string s.
public class RestoreIPAddress {

  private static List<String> restoreIPAddress(String str) {
    List<String> list = new ArrayList<>();
    if (str.length() > 12) {    // In IPV4 format address is of 12 digit max excluding '.'
      return list;
    }
    restoreIP(str, 3, list, "");
    return list;
  }

  private static void restoreIP(String s, int dot, List<String> list, String ip) {
    if (dot == 0 && isValidIP(s)) {
      ip += s;
      list.add(ip);
      return;
    }
    for (int i = 1; i <= 3 && i < s.length(); i++) {
      String address = s.substring(0, i);
      if (isValidIP(address)) {
        restoreIP(s.substring(i), dot - 1, list, ip + address + ".");
      }
    }
  }

  private static boolean isValidIP(String str) {
    if (str.charAt(0) == '0' && str.length() != 1) {
      return false;
    }
    return Integer.parseInt(str) <= 255;
  }

  public static void main(String[] args) {
    System.out.println(restoreIPAddress("0000"));
    System.out.println(restoreIPAddress("1111"));
    System.out.println(restoreIPAddress("010010"));
    System.out.println(restoreIPAddress("101023"));
    System.out.println(restoreIPAddress("25525511115"));
    System.out.println(restoreIPAddress("25525511115"));
  }
}
