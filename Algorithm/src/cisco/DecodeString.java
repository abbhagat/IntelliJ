package cisco;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

    private static String decodeString(String s) {
        String decode = "";
        Deque<String> result = new ArrayDeque<>();
        Deque<Integer> count = new ArrayDeque<>();
        int n = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = 10 * n + c - '0';
            } else if (c == '[') {
                count.push(n);
                n = 0;
                result.push(decode);
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
