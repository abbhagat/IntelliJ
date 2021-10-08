package leetcode;

public class AddLargeNumInsufficientDataTypeToHold {

    public static void main(String[] args) {
        String num1 = "111", num2 = "100";
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(i) - '0' : 0;
            int sum = x + y + carry;
            int mod = sum % 10;
            result.append(mod);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry != 0) {
            result.append(carry);
        }
        System.out.println(result.reverse());
    }
}
