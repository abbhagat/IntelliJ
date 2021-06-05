package trees;

public class LCA {

    Node LCA(Node root, int num1, int num2) {

        if (root != null && num1 < root.num && num2 > root.num) {
            return root;
        } else if (num1 < root.num && num2 < root.num) {
            return LCA(root.left, num1, num2);
        } else if (num1 > root.num && num2 > root.num) {
            return LCA(root.right, num1, num2);
        } else {
            return root;
        }
    }
}
