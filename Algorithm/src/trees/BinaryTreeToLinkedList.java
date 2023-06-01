package trees;

import static trees.TreeTraversal.inorder;

public class BinaryTreeToLinkedList {

    private static Node head, temp;

    private static void treeToLinkedList(Node root) {
        if (root == null) {
            return;
        }
        treeToLinkedList(root.left);
        if (head == null) {
            head = root;
        } else {
            temp.right = root;
        }
        temp = root;
        temp.left = null;
        treeToLinkedList(root.right);
    }

    public static void main(String[] args) {
        Node root  = new Node(2);
        root.left  = new Node(1);
        root.right = new Node(3);
        inorder(root);
        treeToLinkedList(root);
        System.out.println();
        for(Node temp = head; temp != null; temp = temp.right) {
            System.out.println(temp.num);
        }
        System.out.println();
    }
}
