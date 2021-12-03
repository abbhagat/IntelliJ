package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static trees.CreateBST.createBST;
import static trees.TreeTraversal.inorder;

//Expected Time Complexity: O(NLogN).
//Expected Auxiliary Space: O(N).

public class ConvertBTreeToBST {

    private static List<Integer> list = new ArrayList<>();

    public static void preOrder(Node root) {
        if (null != root) {
            list.add(root.num);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root         = new Node(10);
        root.left         = new Node(30);
        root.right        = new Node(15);
        root.left.left    = new Node(20);
        root.right.right  = new Node(5);
        inorder(root);
        preOrder(root);
        System.out.println();
        Collections.sort(list);
        root = null;
        for (int x : list) {
            root = createBST(root, x);
        }
        inorder(root);
    }
}
