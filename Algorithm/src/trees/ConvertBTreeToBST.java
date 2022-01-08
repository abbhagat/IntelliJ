package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(NLogN).
// Auxiliary Space: O(N).

public class ConvertBTreeToBST {

    private static List<Integer> list = new ArrayList<>();
    private static int index;

    public static void createList(Node root) {
        if (null != root) {
            list.add(root.num);
            createList(root.left);
            createList(root.right);
        }
    }

    private static void listToBST(List<Integer> list, Node root) {
        if (root != null) {
            listToBST(list, root.left);
            root.num = list.get(index++);
            listToBST(list, root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        inorder(root);
        createList(root);
        list.sort(Comparator.comparingInt(i -> i));
        System.out.println();
        listToBST(list, root);
        inorder(root);
    }
}
