package linkedlist;

import static linkedlist.LinkList.add;

// Time complexity : O(m + n)
public class IntersectionPointOfTwoLinkedList {

    private static int countNodes(Node node) {
        int count = 0;
        for (Node temp = node; temp != null; temp = temp.next) {
            count++;
        }
        return count;
    }

    private static Node findIntersectionPoint(Node head1, Node head2) {
        int count1 = countNodes(head1);
        int count2 = countNodes(head2);
        int diff = Math.abs(count1 - count2);
        return count1 > count2 ? findIntersectionPoint(head1, head2, diff) : findIntersectionPoint(head2, head1, diff);
    }

    private static Node findIntersectionPoint(Node head1, Node head2, int diff) {
        for (int i = 1; i <= diff; i++) {
            if (head1 == null) {
                return null;
            }
            head1 = head1.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.num == head2.num) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 9, 15, 30};
        int[] b = {10, 15, 30};
        Node l1 = null, l2 = null;
        for (int x : a) {
            l1 = add(l1, x);
        }
        LinkList.temp = LinkList.last = null;
        for (int x : b) {
            l2 = add(l2, x);
        }
        Node node = findIntersectionPoint(l1, l2);
        System.out.println(node.num);
    }
}
