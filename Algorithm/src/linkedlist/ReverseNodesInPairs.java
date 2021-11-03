package linkedlist;

public class ReverseNodesInPairs {

    private static Node reverseNodesInPairs(Node first) {
        Node head = new Node(-1, first);
        Node curr = head;
        while (curr != null && curr.next != null && curr.next.next != null) {
            curr.next = swap(curr.next, curr.next.next);
            curr = curr.next.next;
        }
        return head.next;
    }

    private static Node swap(Node a, Node b) {
        a.next = b.next;
        b.next = a;
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        TraverseList.traverseList(first);
        first = reverseNodesInPairs(first);
        TraverseList.traverseList(first);
    }
}
