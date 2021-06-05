package trees;

public class BinaryTree {

    public static Node createBT(int num, Node root) {
        if (root == null) {
            root = new Node();
            root.num = num;
            root.left = null;
            root.right = null;
        } else if (num % 2 == 0) {
            root.left = createBT(num, root.left);
        } else {
            root.right = createBT(num, root.right);
        }
        return root;
    }
}
