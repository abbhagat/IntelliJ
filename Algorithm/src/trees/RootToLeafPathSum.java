package trees;

public class RootToLeafPathSum {

    public static void rootToLeafPathSum(Node root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.num;
        if (root.left == null && root.right == null) {
            System.out.println(sum);
            return;
        }
        rootToLeafPathSum(root.left,  sum);
        rootToLeafPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        /*
                       4
                      / \
                     2   7
                    / \  /\
                   1  3  6 8
         */

        Node root           = new Node(4);
        root.left           = new Node(2);
        root.right          = new Node(7);
        root.left.left      = new Node(1);
        root.left.right     = new Node(3);
        root.right.left     = new Node(6);
        root.right.right    = new Node(8);
        rootToLeafPathSum(root, 0);
    }
}
