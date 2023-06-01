package amazon;

// Time Complexity O(n)

public class AddTwoBinaryStringAndPrintTheResultInBinaryString {

    private static String addBinary(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int x = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int y = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            result.insert(0, sum % 2);
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    private static String addDecimal(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int x = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int y = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    private static String addOctal(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int x = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int y = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 8;
            result.insert(0, sum % 8);
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1010"));
        System.out.println(addDecimal("15", "20"));
        System.out.println(addOctal("156", "203"));
    }
}
