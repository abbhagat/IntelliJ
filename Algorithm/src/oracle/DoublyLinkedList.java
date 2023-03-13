package oracle;

class DoublyLinkedList {

    final int size;
    int currSize;
    Node head, tail;

    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }

    public void printList() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.num + " ");
        }
    }

    public Node addPageToList(int num) {
        Node node = new Node(num);
        if (head == null) {
            head = node;
            tail = node;
            currSize = 1;
            return node;
        } else if (currSize < size) {
            currSize++;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        node.next = head;
        head.prev = node;
        head = node;
        return node;
    }

    public void movePageToHead(Node pageNode) {
        if (pageNode == null || pageNode == head) {
            return;
        }
        if (pageNode == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        Node prev = pageNode.prev;
        Node next = pageNode.next;
        prev.next = next;
        if (next != null) {
            next.prev = prev;
        }
        pageNode.prev = null;
        pageNode.next = head;
        head.prev = pageNode;
        head = pageNode;
    }
}
