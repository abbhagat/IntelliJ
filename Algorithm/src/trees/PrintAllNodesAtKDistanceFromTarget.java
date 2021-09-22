package trees;

import static trees.CreateBST.createBST;

public class PrintAllNodesAtKDistanceFromTarget {

    private static void printKDistanceNodeDown(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(root.num);
            return;
        }
        printKDistanceNodeDown(root.left, k - 1);
        printKDistanceNodeDown(root.right, k - 1);
    }

    private static int printKDistanceNode(Node root, Node target, int k) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            printKDistanceNodeDown(root, k);
            return 0;
        }
        int dl = printKDistanceNode(root.left, target, k);  // dl is Distance of root's left child from target
        if (dl != -1) {
            if (dl + 1 == k) {   // If root is at distance k from target, print root
                System.out.print(root.num);
            } else {
                printKDistanceNodeDown(root.right, k - dl - 2);  // Else go to right subtree and print all k-dl-2 distant nodes Note that the right child is 2 edges away from left child
            }
            return 1 + dl;   // Add 1 to the distance and return value for parent calls
        }
        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE  Note that we reach here only when root was not found in left subtree
        int dr = printKDistanceNode(root.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k) {
                System.out.print(root.num);
            } else {
                printKDistanceNodeDown(root.left, k - dr - 2);
            }
            return 1 + dr;
        }
        return -1;   // If target was neither present in left nor in right subtree
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120, 27, 35};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        printKDistanceNode(root, root.left, 2);
    }
}
