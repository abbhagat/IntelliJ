package leetcode;

public class AddLargeNumInsufficientDataTypeToHold {

    private String add(String num1, String num2) {
        int carry = 0, l1 = num1.length() - 1, l2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= l1 || i <= l2; i++) {
            int x = i <= l1 ? num1.charAt(l1 - i) - '0' : 0;
            int y = i <= l2 ? num2.charAt(l2 - i) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        return carry == 0 ? result.toString() : "1" + result;
    }

    public static void main(String[] args) {
        AddLargeNumInsufficientDataTypeToHold obj = new AddLargeNumInsufficientDataTypeToHold();
        System.out.println(obj.add("111", "100"));
        System.out.println(obj.add("10", "20"));
        System.out.println(obj.add("5", "3"));
    }
}
