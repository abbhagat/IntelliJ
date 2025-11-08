package linkedlist;

public class TraverseList {

    public static void traverseList(Node first) {
        for (Node temp = first; temp != null; temp = temp.next) {
            System.out.print(temp.num + " ");
        }
        System.out.println();
    }

    public static void traverseCyclicList(Node node) {
        Node temp = node;
        do {
            System.out.print(temp.num + " ");
            temp = temp.next;
        } while (temp != node);
    }
}
