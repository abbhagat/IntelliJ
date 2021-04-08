package linkedlist;

public class TraverseList {

    public static void traverseList(Node first) {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.num + " ");
            temp = temp.next;
        }
        System.out.println("\nSize :" + LinkList.size);
    }
}
