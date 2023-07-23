package trees;

import static trees.LCA.lca;

public class DistanceBetweenTwoGivenNodesOfABST {

    private static int findLevel(Node root, int num, int level) {
        if (root == null) {
            return -1;
        }
        if (root.num == num) {
            return level;
        }
        int    distance  =      findLevel(root.left,  num, level + 1);
        return distance == -1 ? findLevel(root.right, num, level + 1) : distance;
    }

    private static int findDistance(Node root, int num1, int num2) {
        Node lca = lca(root, num1, num2);
        return findLevel(lca, num1, 0) + findLevel(lca, num2, 0);
    }

    public static void main(String[] args) {
        /*
                    15
                  /    \
                10      20
               / \     /  \
              8  12   16  25
       */
        Node root           = new Node(15);
        root.left           = new Node(10);
        root.right          = new Node(20);
        root.left.left      = new Node(8);
        root.left.right     = new Node(12);
        root.right.left     = new Node(16);
        root.right.right    = new Node(25);
        System.out.println(findDistance(root, 15, 12));
        System.out.println(findDistance(root, 8 , 12));
        System.out.println(findDistance(root, 8 , 25));
    }
}
