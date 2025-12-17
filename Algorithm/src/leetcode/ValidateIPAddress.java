package leetcode;

// Time  Complexity : O(1)
// Space Complexity : O(1)
public class ValidateIPAddress {

  private static boolean isValidIPv4(String ipAddress) {
    String[] ipv4 = ipAddress.split("\\.");
    if (ipv4.length != 4) {
      return false;
    }
    for (String s : ipv4) {
      if (s.isEmpty() || s.length() > 3) {
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

  private static boolean isValidIPv6(String ipAddress) {
    String[] ipv6 = ipAddress.split(":");
    if (ipv6.length != 8) {
      return false;
    }
    String hexDigits = "0123456789abcdefABCDEF";
    for (String s : ipv6) {
      if (s.isEmpty() || s.length() > 4) {
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
    System.out.println(isValidIPv4("204.120.0.255"));
    System.out.println(isValidIPv4("204.120.120.255"));
    System.out.println(isValidIPv4("204.120.01.1"));
    System.out.println(isValidIPv6("2001:db8:3333:4444:5555:6666:7777:8888"));
    System.out.println(isValidIPv6("2001:db8:3!33:4444:5555:6666:7777:8888"));
  }
}
