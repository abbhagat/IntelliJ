package trees;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;

/*
 *       1
 *      / \
 *     2    3
 *    / \  / \
 *   4   5 6  7
 *
 * O/P :- [[4, 5, 6, 7], [2, 3], [1]]
 */

public class CollectAndRemoveAllLeafNodesOfABinaryTree {

    // traverse the tree bottom-up recursively
    private static int treeHeight(List<List<Integer>> list, Node root) {
        if (root == null) {
            return -1;
        }
        int lH = treeHeight(list, root.left);
        int rH = treeHeight(list, root.right);
        int height = max(lH, rH) + 1;
        if (list.size() <= height) {
            list.add(new ArrayList<>());
        }
        list.get(height).add(root.num);
        return height;
    }

    public static List<List<Integer>> findLeaves(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        treeHeight(list, root);
        return list;
    }

    public static void main(String[] args) {
        Node root        = new Node(1);
        root.left        = new Node(2);
        root.right       = new Node(3);
        root.left.left   = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        root.right.right = new Node(7);
        System.out.println(findLeaves(root));
    }
}
