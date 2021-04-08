package trees;

import java.util.Stack;

public class IterativeTreeTraversal {

    static void iterativeTreeTraversal(BST root) {
        if (null == root) {
            return;
        }
        Stack<BST> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            System.out.print(root.num + " ");
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1};
        BST root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        iterativeTreeTraversal(root);
        System.out.println();
    }
}
