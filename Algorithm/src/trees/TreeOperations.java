package trees;

public class TreeOperations {

    public static void main(String... args) {
        int[] a = { 30, 10, 50, 5, 20, 40, 60 };
        Node root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        TreeTraversal t = new TreeTraversal();
        t.inorder(root);
        System.out.println("\nComplete Binary Tree :" + new IsCompleteBT().isCompleteBT(root));
        System.out.println();
        DeleteNodeFromBST d = new DeleteNodeFromBST();
        root = d.deleteNodeFromBST(root, 40);
        t.inorder(root);
        System.out.println();
    }

}
