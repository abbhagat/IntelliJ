package trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSum {

    public static void rootToLeafPathSum(Node root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum += root.num;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return;
        }
        rootToLeafPathSum(root.left,  sum, list);
        rootToLeafPathSum(root.right, sum, list);
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
        List<Integer> list = new ArrayList<>();
        rootToLeafPathSum(root, 0, list);
        System.out.println(list);
    }
}
