package stack;

import java.util.Stack;

public class StackDemo {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>();
    System.out.println(s.push(1));
    System.out.println(s.push(2));
    System.out.println(s.push(3));
    System.out.println(s.push(4));
    System.out.println(s.push(5));
    System.out.println(s);
    System.out.println(s.firstElement());
    System.out.println(s.lastElement());
    System.out.println(s.peek());
    System.out.println(s.pop());
    System.out.println(s);
  }
}
