package cisco;

import java.util.Stack;

public class DecodeString {

    private static String decodeString(String s) {
        int n = 0; String decode = "";
        Stack<String>  result = new Stack<>();
        Stack<Integer> count  = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = 10 * n + c - '0';
            } else if (c == '[') {
                count.push(n);
                result.push(decode);
                n = 0;
                decode = "";
            } else if (c == ']') {
                String temp = decode;
                decode = result.pop();
                for (int i = count.pop(); i > 0; i--) {
                    decode += temp;
                }
            } else {
                decode += c;
            }
        }
        return decode;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
