package amazon;

// Time Complexity O(n)

public class AddTwoBinaryStringAndPrintTheResultInBinaryString {

    private static String add(String num1, String num2, int base) {
        StringBuilder result = new StringBuilder();
        int carry = 0, l1 = num1.length(), l2 = num2.length();
        for (int i = 0; i < l1 || i < l2; i++) {
            int x = i < l1 ? num1.charAt(l1 - 1 - i) - '0' : 0;
            int y = i < l2 ? num2.charAt(l2 - 1 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / base;
            result.insert(0, sum % base);
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    public static void main(String[] args) {
        System.out.println(add("1111", "1010", 2));
        System.out.println(add("15", "20", 8));
        System.out.println(add("156", "203", 10));
    }
}
