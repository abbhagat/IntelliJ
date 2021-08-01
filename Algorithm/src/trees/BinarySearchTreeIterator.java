package trees;

import java.util.Stack;

import static trees.BinaryTree.createBT;

public class BinarySearchTreeIterator {

    private static Stack<Node> stack;

    private static Node curr() {
        return stack.peek();
    }

    private static void next() {
        Node temp = stack.peek().right;
        stack.pop();
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    private static boolean hasNext() {
        return !stack.isEmpty();
    }

    private static void iterate() {
        while (hasNext()) {
            System.out.print(curr().num + " ");
            next();
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBT(a[i], root);
        }
        stack = new Stack<>();
        Node curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        iterate();
    }
}
