package linkedlist;

import static linkedlist.LinkList.add;

public class IsCyclic {

    public static boolean hasCycle(Node first) {
        if (first == null || first.next == null) {
            return false;
        }
        Node slow = first, fast = first.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow || fast.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        LinkList.last.next = first;
        System.out.println(hasCycle(first));
    }
}
