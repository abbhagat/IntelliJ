package linkedlist;

public class TraverseList {

    public static void traverseList(Node first) {
        for (Node temp = first; temp != null; temp = temp.next) {
            System.out.print(temp.num + " ");
        }
    }
}
