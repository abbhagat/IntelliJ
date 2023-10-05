package trees;

import static java.lang.Integer.max;

public class MaxPathSumInBT {

    static class Result {
        int sum = Integer.MIN_VALUE;
    }

    private static int findMaxPathSum(Node root, Result result) {
        if (root == null) {
            return 0;
        }
        int left   = findMaxPathSum(root.left,  result);   // find maximum path sum "starting" from the left child
        int right  = findMaxPathSum(root.right, result);  //  find maximum path sum "starting" from the right child
        int max    = result.sum;                         //   Try all possible combinations to get the optimal result
            max    = max(max, root.num);
            max    = max(max, root.num + left);
            max    = max(max, root.num + right);
            max    = max(max, root.num + left + right);
        result.sum = max;
        return max(root.num, root.num + max(left, right));
    }

    public static void main(String[] args) {
        /*
                       10
                      /  \
                    2     10
                   / \      \
                  20  1     -25
                            /  \
                            3   4
         */
        Node root              = new Node(10);
        root.left              = new Node(2);
        root.right             = new Node(10);
        root.left.left         = new Node(20);
        root.left.right        = new Node(1);
        root.right.right       = new Node(-25);
        root.right.right.left  = new Node(3);
        root.right.right.right = new Node(4);
        Result result = new Result();
        findMaxPathSum(root, result);
        System.out.println("The maximum path sum is " + result.sum);
    }
}
