package trees;

class BSTree {
    int num;
    int count;
    BSTree left, right;
}

public class FrequencyOfEachElementInAnArray {

    static BSTree createBST(BSTree root, int num) {
        if (root == null) {
            root = new BSTree();
            root.num = num;
            root.count = 1;
            root.left = null;
            root.right = null;
        } else {
            if (num < root.num) {
                root.left = createBST(root.left, num);
            } else if (num > root.num) {
                root.right = createBST(root.right, num);
            } else {
                root.count = root.count + 1;
            }
        }
        return root;
    }

    public static void inorder(BSTree root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.num + " --> " + root.count);
            System.out.println();
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 7, 9, 1, 2, 3, 4, 3, 3, 5, 6, 0, 1, 0, 1};
        BSTree root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        inorder(root);
    }
}
