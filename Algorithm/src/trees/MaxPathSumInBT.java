package trees;

import static java.lang.Integer.max;

public class MaxPathSumInBT {

    static class Result {
        int sum = Integer.MIN_VALUE;
    }

    public static int findMaxPathSum(Node node, Result result) {
        if (node == null) {
            return 0;
        }
        int left  = findMaxPathSum(node.left, result);    // find maximum path sum "starting" from the left child
        int right = findMaxPathSum(node.right, result);  //  find maximum path sum "starting" from the right child
        int max = result.sum;     // Try all possible combinations to get the optimal result
        max = max(max, node.num);
        max = max(max, node.num + left);
        max = max(max, node.num + right);
        max = max(max, node.num + left + right);
        result.sum = max;
        // return the maximum path sum "starting" from the given node
        return max(node.num, node.num + max(left, right));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        Result result = new Result();
        findMaxPathSum(root, result);
        System.out.println("The maximum path sum is " + result.sum);
    }
}
