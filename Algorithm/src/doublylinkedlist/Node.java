package doublylinkedlist;

class Node {
    int num;
    Node left, right;

    public Node(int num) {
        this.num = num;
        this.left = this.right = null;
    }
}
