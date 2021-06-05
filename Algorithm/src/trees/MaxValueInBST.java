package trees;

public class MaxValueInBST {

    public static void main(String[] args) {
        int[] a = {10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7};
        Node root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        System.out.println(new MaxValueInBST().maxValueInBST(root).num);
    }

    private Node maxValueInBST(Node root) {
        if (null != root) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

}
