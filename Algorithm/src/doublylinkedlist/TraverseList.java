package doublylinkedlist;

public class TraverseList {

    static void traverseList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.num + " ");
            temp = temp.right;
        }
        System.out.println("\nSize :" + CreateList.size);
    }
}
