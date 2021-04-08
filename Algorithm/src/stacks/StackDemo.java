package stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        System.out.println(s.firstElement());
        System.out.println(s.lastElement());
        s.pop();
        System.out.println(s);
    }
}
