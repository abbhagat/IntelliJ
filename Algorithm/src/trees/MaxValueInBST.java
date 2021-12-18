package trees;

import static trees.CreateBST.createBST;

public class MaxValueInBST {

    public static Node maxValueInBST(Node root) {
        while (null != root && null != root.right) {
            root = root.right;
        }
        return root;
    }

    public static Node maxValueBST(Node root) {
        if (null != root && null != root.right) {
            root = maxValueBST(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(maxValueInBST(root).num);
        System.out.println(maxValueBST(root).num);
    }
}
