package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {

    private static boolean detectAndRemoveLoop(Node first) {
        Node slow = first, fast = first.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            if (fast == slow || fast.next == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        }
        fast.next = null;
        return true;
    }

    private static void removeCycle(Node slow, Node fast) {
        if (fast == slow) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        }
        fast.next = null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
       first.next.next.next.next = first.next.next;
        boolean flag = detectAndRemoveLoop(first);
        if(flag){
            traverseList(first);
        }else{
            System.out.println("Linked List has no cycle");
        }
    }
}
