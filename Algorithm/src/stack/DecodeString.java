package stack;

import java.util.Stack;
import static java.lang.Character.isDigit;

public class DecodeString {

  private static String decodeString(String str) {
    Stack<String>  stack = new Stack<>();
    Stack<Integer> count = new Stack<>();
    String decode = "";
    int n = 0;
    for (char c : str.toCharArray()) {
      if (isDigit(c)) {
        n = n * 10 + c - '0';
      } else if (c == '[') {
        stack.push(decode);
        count.push(n);
        decode = "";
        n = 0;
      } else if (c == ']') {
        String s = decode;
        decode   = stack.pop();
        int k    = count.pop();
        decode  += s.repeat(k);
      } else {
        decode += c;
      }
    }
    return decode;
  }

  public static void main(String[] args) {
    System.out.println(decodeString("3[a]2[bc]"));        // aaabcbc
    System.out.println(decodeString("3[a2[c]]"));        // accaccacc
    System.out.println(decodeString("2[abc]3[cd]ef"));  // abcabccdcdcdef
  }
}
