package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

//Time Complexity:  O(m+n)

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
            a = add(a, x);
        }
        for (int x : new int[]{2, 4}) {
            b = add(b, x);
        }
        traverseList(a);
        traverseList(b);
        traverseList(mergeTwoLists(a, b));
    }
}
