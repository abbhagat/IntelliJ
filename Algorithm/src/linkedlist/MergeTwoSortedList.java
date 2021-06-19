package linkedlist;

public class MergeTwoSortedList {

    public static Node mergeTwoLists(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.num < b.num) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        } else {
            b.next = mergeTwoLists(a, b.next);
            return b;
        }
    }

    public static void main(String[] args) {
        Node a = null, b = null;
        for (int x : new int[]{1, 3}) {
            a = LinkList.add(x, null);
        }
        LinkList.first = null;
        LinkList.size = 0;
        for (int x : new int[]{2, 4}) {
            b = LinkList.add(x, null);
        }
        TraverseList.traverseList(a);
        TraverseList.traverseList(b);
        TraverseList.traverseList(mergeTwoLists(a, b));
    }
}
