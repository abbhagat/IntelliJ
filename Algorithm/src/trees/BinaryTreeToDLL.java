package trees;

public class BinaryTreeToDLL {

    private static Node prev, head;

    private static Node convertTreeToDLL(Node root) {
        if (root == null) {
            return null;
        }
        convertTreeToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        convertTreeToDLL(root.right);
        return head;
    }

    public static void main(String[] args) {
        Node root       = new Node(10);
        root.left       = new Node(12);
        root.right      = new Node(15);
        root.left.left  = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root = convertTreeToDLL(root);
        for (Node temp = root; temp != null; temp = temp.right) {
            System.out.print(temp.num + " ");
        }
    }
}