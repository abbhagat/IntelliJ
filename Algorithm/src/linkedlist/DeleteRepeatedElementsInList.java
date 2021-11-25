package linkedlist;

import java.util.HashMap;
import java.util.Map;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DeleteRepeatedElementsInList {

    private static Node deleteRepeatedElementUsingMap(Node first) {
        Map<Integer,Node> map = new HashMap<>();
        Node prev = null;
        for(Node temp = first; temp != null; temp = temp.next){
            if(map.containsKey(temp.num)){
                prev.next = temp.next;
                return first;
            }
            map.put(temp.num, temp);
            prev = temp;
        }
        return first;
    }

    private static Node deleteRepeatedElement(Node first) {
        Node prev_slow = first;
        Node slow      = first;
        Node fast      = first.next;
        while (true) {
            if (slow.num == fast.num) {
                if (slow == prev_slow) {
                    return slow.next;
                }
                prev_slow.next = slow.next;
                return first;
            }
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next == null || fast.next.next == null ? first : fast.next.next;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 3, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        first = deleteRepeatedElementUsingMap(first);
        traverseList(first);
    }
}
