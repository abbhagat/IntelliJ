package trees;

import static trees.TreeTraversal.inorder;

public class BinaryTreeToLinkedList {

    private static void treeToList(Node root){
        if(root == null){
            return;
        }
        treeToList(root.left);
        treeToList(root.right);
        Node node  = root.right;
        root.right = root.left;
        root.left  = null;
        Node curr  = root;
        while (curr.right != null){
            curr = curr.right;
        }
        curr.right = node;
    }

    public static void main(String[] args) {
        Node root        = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        inorder(root);
        treeToList(root);
        System.out.println();
        inorder(root);
    }
}
