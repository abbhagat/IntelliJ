package doublylinkedlist;

public class CreateList {
    static Node temp, first, last;
    static int size = 0;

    static Node createList(int num, Node node) {

        if (node == null) {
            node = new Node();
            node.num = num;
            node.left = null;
            node.right = null;
            size++;
        }
        if (first == null) {
            first = last = node;
            temp = node;
        } else {
            temp.right = node;
            node.left = temp;
            temp = last = node;
        }
        return first;
    }
}
