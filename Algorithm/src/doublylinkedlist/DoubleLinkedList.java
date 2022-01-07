package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

public class DoubleLinkedList {
    public static void main(String[] args) {
        Node node = null;
        for (int i = 10; i <= 100; i += 10) {
            node = createList(i, null);
        }
        traverseList(node);
    }
}
