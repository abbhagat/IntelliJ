package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.CreateBST.createBST;

// Time Complexity  : O(n)
// Space Complexity : O(2^h)
public class IterativeTreeTraversal {

    public static void iterativeTreeTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.poll();
            System.out.print(root.num + " ");
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        iterativeTreeTraversal(root);
        System.out.println();
    }
}
