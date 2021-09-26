package trees;

import static trees.TreeTraversal.inorder;

public class IsSubTree {

    private static boolean isSubTree(Node rootSuper, Node rootSub) {

        if (rootSuper == rootSub & rootSuper == null) {
            return true;
        } else if (rootSuper == null || rootSub == null) {
            return false;
        }
        if (rootSuper.num == rootSub.num) {
            return isSubTree(rootSuper.left, rootSub.left) && isSubTree(rootSuper.right, rootSub.right);
        } else {
            return isSubTree(rootSuper.left, rootSub) || isSubTree(rootSuper.right, rootSub);
        }
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1};
        Node rootSuper = null, rootSub = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            rootSuper = bst.createBST(rootSuper, a[i]);
        }
        int[] b = {10, 5, 20, 1};
        bst = new CreateBST();
        for (int i = 0; i < b.length; i++) {
            rootSub = bst.createBST(rootSub, b[i]);
        }
        inorder(rootSuper);
        System.out.println();
        inorder(rootSub);
        System.out.println();
        System.out.println(isSubTree(rootSuper, rootSub) ? "Is a sub tree" : "Not a sub tree");
    }
}
