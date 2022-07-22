package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(nlogn)
// Auxiliary Space: O(n)

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

    private static void listToBST(Node root, List<Integer> list) {
        if (root != null) {
            listToBST(root.left, list);
            root.num = list.get(index++);
            listToBST(root.right, list);
        }
    }

    public static void main(String[] args) {
        Node root        = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        inorder(root);
        createList(root);
        list.sort(Comparator.comparingInt(i -> i));
        System.out.println();
        listToBST(root, list);
        inorder(root);
    }
}
