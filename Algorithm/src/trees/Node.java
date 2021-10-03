package trees;

public class Node {
    int num;
    Node left, right;

    public Node() {}

    public Node(int num) {
        this.num = num;
        this.left = this.right = null;
    }
}
