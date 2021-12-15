package linkedlist;


// LinkedList  -> 1->5->2->7->8->3
// ReverseList -> 3->8->7->2->5->1
public class ReverseListHackerRank {

    private static Node findPrevLast(Node first, Node last) {
        Node node = null;
        for (Node temp = first; temp != last; temp = temp.next) {
            node = temp;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2, 7, 8, 3};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        int count = 0;
        for (Node temp = first; temp != null; temp = temp.next) {
            count++;
        }
        Node tail = LinkList.last, head = null;
        Node prevLast = findPrevLast(first, tail);
        Node tempFirst = first;
        first.next = prevLast.next.next;
        prevLast.next = first;
        tail = prevLast;
        if (head == null) {
            head = first;
        }
    }
}
