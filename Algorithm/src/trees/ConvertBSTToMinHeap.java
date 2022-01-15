package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.TreeTraversal.preorder;

// Time Complexity: O(n)
// Auxiliary Space: O(n)
public class ConvertBSTToMinHeap {

    private static List<Integer> list = new ArrayList<>();
    private static int index;

    private static void listToMinHeap(Node root) {    // Preorder
        if (root != null) {
            root.num = list.get(index++);
            listToMinHeap(root.left);
            listToMinHeap(root.right);
        }
    }

    public static void createList(Node root) {      // Inorder
        if (null != root) {
            createList(root.left);
            list.add(root.num);
            createList(root.right);
        }
    }

    public static void main(String[] args) {
        Node root        = new Node(4);
        root.left        = new Node(2);
        root.right       = new Node(6);
        root.left.left   = new Node(1);
        root.left.right  = new Node(3);
        root.right.left  = new Node(5);
        root.right.right = new Node(7);
        createList(root);
        System.out.println(list);
        listToMinHeap(root);
        preorder(root);
    }
}
