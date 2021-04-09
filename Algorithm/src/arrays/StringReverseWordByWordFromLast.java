package arrays;

import java.util.Stack;

public class StringReverseWordByWordFromLast {

    static void reverseWordByWord(String s) {
        String[] str = s.split(" ");
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i] + " ");
        }
    }

    public static void main(String[] args) {
        reverseWordByWord("This is a sentence.");
        System.out.println();
        char[] c = "This is a sentence.".toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0, j = 0;
        String s = "";
        for (i = c.length - 2; i >= 0; i--) {
            if (c[i] != ' ') {
                stack.push(c[i]);
            } else {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(c[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.print(c[c.length - 1]);
    }
}
