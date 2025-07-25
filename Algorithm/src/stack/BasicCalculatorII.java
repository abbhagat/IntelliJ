package stack;

import java.util.Stack;

public class BasicCalculatorII {

    private static int calculate(String exp) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        char sign = '+';
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == exp.length() - 1) {
                switch (sign) {
                    case '+' -> stack.push(n);
                    case '-' -> stack.push(-n);
                    case '*' -> stack.push(stack.pop() * n);
                    case '/' -> stack.push(stack.pop() / n);
                }
                sign = c;
                n = 0;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println("3+2*2    = " + calculate("3+2*2"));
        System.out.println("3/2      = " + calculate("3/2"));
        System.out.println("3 +5 / 2 = " + calculate(" 3 +5 / 2"));
    }
}
