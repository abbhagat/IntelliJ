package linkedlist;

import java.util.HashMap;
import java.util.Map;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time complexity: O(n)

public class DeleteRepeatedElementsInList {

    private static Node deleteRepeatedElementUsingMap(Node first) {
        Map<Integer, Node> map = new HashMap<>();
        for (Node temp = first; temp != null; temp = temp.next) {
            if (map.containsKey(temp.num)) {
                Node node = map.get(temp.num);
                node.next = node.next.next;
            }
            map.put(temp.num, temp);
        }
        return first;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 3, 5, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        first = deleteRepeatedElementUsingMap(first);
        traverseList(first);
    }
}
