package trees;

import static trees.CreateBST.createBST;
import static trees.LCA.LCA;

public class DistanceBetweenTwoGivenNodesOfABST {

    public static int findLevel(Node root, int num, int level) {
        if (root == null) {
            return -1;
        }
        if (root.num == num) {
            return level;
        }
        int dist = findLevel(root.left, num,  level + 1);
        if (dist == -1) {
            return findLevel(root.right, num, level + 1);
        }
        return dist;
    }

    private static int findDistance(Node root, int num1, int num2) {
        Node lca = LCA(root, num1, num2);
        return findLevel(lca, num1, 0) + findLevel(lca, num2, 0);
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1, 6};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(findDistance(root, 1, 20));
    }
}
