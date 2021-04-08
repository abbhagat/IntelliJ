package doublylinkedlist;

public class DoubleLinkedList {
    public static void main(String[] args) {
        Node node = null;
        for (int i = 10; i <= 100; i += 10) {
            node = CreateList.createList(i, null);
        }
        TraverseList.traverseList(node);
    }
}
