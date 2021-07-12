package linkedlist;

public class InsertNodeInSortedLinkedList {

    public static Node insertNodeInSortedLinkedList(Node first, int num) {
        if (null == first || first.num > num) {
            return new Node(num, first);
        } else {
            for (Node temp = first, prev = temp; temp != null; temp = temp.next) {
                if (num < temp.num) {
                    Node node = new Node(num, temp);
                    prev.next = node;
                    return first;
                }
                prev = temp;
            }
            return first;
        }
    }

    public static void main(String[] args) {
        Node a = null;
        for (int x : new int[]{1, 3, 5, 9}) {
            a = LinkList.add(null, x);
        }
        TraverseList.traverseList(insertNodeInSortedLinkedList(a, 8));
    }
}
