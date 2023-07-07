package stack;

import java.util.Stack;

public class QueueWithTwoStacks<K> {

    Stack<K> s1 = new Stack<>();
    Stack<K> s2 = new Stack<>();

    void deQueue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        System.out.println(s2.pop());
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    void enQueue(K k) {
        s1.push(k);
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<>();
        for (int i = 1; i <= 5; i++) {
            q.enQueue(i);
        }
        System.out.println(q.s1);
        System.out.println(q.s2);
        q.deQueue();
        q.enQueue(6);
        System.out.println(q.s2);
        System.out.println(q.s1);
        q.deQueue();
        System.out.println(q.s1);
        System.out.println(q.s2);
    }
}
