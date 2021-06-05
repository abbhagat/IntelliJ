package trees;

public class SumOfNonRepeatedNumInAnArray {

    static int sum = 0;

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.num + " ");
            inorder(root.right);
        }
    }

    static void findSum(Node root) {
        if (root != null) {
            findSum(root.left);
            sum += root.num;
            findSum(root.right);
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 1, 2, 10, 9, 8, 7, 6, 10, 9 };
        Node root = null;
        CreateBST bst = new CreateBST();
        for (int num : a) {
            root = bst.createBST(root, num);
        }
        inorder(root);
        System.out.println();
        findSum(root);
        System.out.println("Sum of non repeated numbers :" + sum);
    }

}
