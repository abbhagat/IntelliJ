package stack;

public class StackPopnPush {

    Node temp, first;
    char c;

    Node push(char num, Node node) {
        if (node == null) {
            node = new Node();
            node.num = num;
            node.next = null;
        }
        if (first == null) {
            temp = first = node;
        } else {
            node.next = temp;
            temp = first = node;
        }
        return first;
    }

    Node pop(Node first) {
        Node temp = null;
        if (first != null) {
            temp = first.next;
            first = temp;
        }
        return temp;
    }

    void display(Node first) {
        Node temp;
        for (temp = first; temp != null; temp = temp.next) {
            System.out.print(temp.num + " ");
        }
        System.out.println();
    }
}
