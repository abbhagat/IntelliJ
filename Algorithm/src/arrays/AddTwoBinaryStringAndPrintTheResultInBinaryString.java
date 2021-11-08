package arrays;

import static arrays.ToDecimalFromBinary.toDecimal;
import static geeks.ParseIntImplementation.parseInt;
import static geeks.ToBinaryFromDecimal.toBinary;

public class AddTwoBinaryStringAndPrintTheResultInBinaryString {

    private static String add(String num1, String num2) {
        int i = 0, carry = 0, l1 = num1.length() - 1, l2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i <= l1 || i <= l2) {
            int x = i <= l1 ? num1.charAt(l1 - i) - '0' : 0;
            int y = i <= l2 ? num2.charAt(l2 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            result.insert(0, sum % 2);
            i++;
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    public static void main(String[] args) {
        String x = "1111";
        String y = "1010";
        int a = toDecimal(parseInt(x));
        int b = toDecimal(parseInt(y));
        int c = a + b;
        String z = toBinary(c);
        System.out.println(z);
        System.out.println(add(x, y));
    }
}
