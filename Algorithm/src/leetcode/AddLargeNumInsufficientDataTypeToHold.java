package leetcode;

import static java.lang.Integer.max;

public class AddLargeNumInsufficientDataTypeToHold {

    private static String add(String num1, String num2) {
        int carry = 0, l1 = num1.length() - 1, l2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= max(l1,l2); i++) {
            int x = i <= l1 ? num1.charAt(l1 - i) - '0' : 0;
            int y = i <= l2 ? num2.charAt(l2 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    public static void main(String[] args) {
        System.out.println(add("111", "100"));
        System.out.println(add("10", "20"));
        System.out.println(add("5", "3"));
    }
}
