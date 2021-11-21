package trees;

import static trees.BinaryTree.createBT;
import static trees.LCA.LCA;

public class DistanceBetweenTwoGivenNodesOfABT {

    private static int findLevel(Node root, Node node, int level) {
        if (root == null) {
            return -1;
        }
        if (root == node) {
            return level;
        }
        int distance = findLevel(root.left, node,  level + 1);
        if (distance == -1) {
            return    findLevel(root.right, node,  level + 1);
        }
        return distance;
    }

    private static int findDistance(Node root, int num1, int num2) {
        Node lca = LCA(root, num1, num2);
        return findLevel(lca, null, 0) + findLevel(lca, null, 0);
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1, 6};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBT(a[i],root);
        }
        System.out.println(findDistance(root, 1, 20));
    }
}
