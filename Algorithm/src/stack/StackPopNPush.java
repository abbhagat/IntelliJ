package stack;

public class StackPopNPush {

    Node first;
    char c;

    Node push(char num) {
        Node node = new Node();
        node.num = num;
        node.next = first;
        first = node;
        return node;
    }

    Node pop(Node first) {
        Node temp = null;
        if (first != null) {
            temp = first.next;
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
