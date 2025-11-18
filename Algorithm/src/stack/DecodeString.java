package stack;

import java.util.Stack;

public class DecodeString {

  private static String decodeString(String s) {
    Stack<String> stack = new Stack<>();
    Stack<Integer> count = new Stack<>();
    int n = 0;
    String decode = "";
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        n = n * 10 + c - '0';
      } else if (c == '[') {
        stack.push(decode);
        count.push(n);
        n = 0;
        decode = "";
      } else if (c == ']') {
        String temp = decode;
        decode = stack.pop();
        int k = count.pop();
        for (int i = k; i > 0; i--) {
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
