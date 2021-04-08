package trees;


public class IsMirrorImage {

    static boolean isMirrorImage(BST root1, BST root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.num == root2.num && isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left);
    }

    public static void main(String[] args) {
        int[] a = {'X', 'D', 'C', 'B', 'A'};
        int[] b = {'X', 'C', 'D', 'A', 'B'};
        BST rootSuper = null, rootSub = null;
        BinaryTree bt = new BinaryTree();
        for (int i = 0; i < a.length; i++) {
            rootSuper = bt.createBT(a[i], rootSuper);
        }
        for (int i = 0; i < b.length; i++) {
            rootSub = bt.createBT(b[i], rootSub);
        }
        TreeTraversal t = new TreeTraversal();
        t.postorder(rootSuper);
        System.out.println();
        t.postorder(rootSub);
        System.out.println();
        System.out.println(isMirrorImage(rootSuper, rootSub) ? "Mirror Image" : "Not a Mirror Image");
    }
}
