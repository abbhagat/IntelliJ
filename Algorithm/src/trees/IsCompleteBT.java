package trees;

public class IsCompleteBT {

    boolean isCompleteBT(Node root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return false;
        }
        return (isCompleteBT(root.left) && isCompleteBT(root.right));
    }

    public static void main(String... args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60};
        Node root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        System.out.println("Complete Binary Tree :" + new IsCompleteBT().isCompleteBT(root));
    }
}
