package trees;

import static trees.CreateBST.createBST;
import static trees.TreeTraversal.inorder;

public class IsSubTree {
    private static boolean isSubTree(Node rootSuper, Node rootSub) {
        if (rootSuper == null && rootSub == null) {
            return true;
        }
        if (rootSuper == null || rootSub == null) {
            return false;
        }
        if (rootSuper.num == rootSub.num) {
            return isSubTree(rootSuper.left, rootSub.left) && isSubTree(rootSuper.right, rootSub.right);
        }
        return isSubTree(rootSuper.left, rootSub) || isSubTree(rootSuper.right, rootSub);
    }

    public static void main(String[] args) {
        int[] a = new int[] {30, 10, 50, 5, 20, 40, 60, 1};
        Node rootSuper = null, rootSub = null;
        for (int x : a) {
            rootSuper = createBST(rootSuper, x);
        }
        a = new int[] {10, 5, 20, 11};
        for (int x : a) {
            rootSub = createBST(rootSub, x);
        }
        inorder(rootSuper);
        System.out.println();
        inorder(rootSub);
        System.out.println();
        System.out.println(isSubTree(rootSuper, rootSub) ? "Is a sub tree" : "Not a sub tree");
    }
}
