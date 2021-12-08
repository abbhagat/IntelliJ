package trees;

import java.util.LinkedList;
import java.util.Queue;

import static trees.CreateBST.createBST;

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
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        iterativeTreeTraversal(root);
        System.out.println();
    }
}
