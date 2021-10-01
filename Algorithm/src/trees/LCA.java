package trees;

public class LCA {

    public static Node LCA(Node root, int num1, int num2) {
        if (root != null) {
            if (num1 < root.num && num2 > root.num) {
                return root;
            }
            if (num1 < root.num && num2 < root.num) {
                return LCA(root.left, num1, num2);
            }
            if (num1 > root.num && num2 > root.num) {
                return LCA(root.right, num1, num2);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1, 6};
        Node root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        Node lca = LCA(root, 1, 20);
        System.out.println(lca.num);
    }
}
