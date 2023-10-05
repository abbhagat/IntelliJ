package trees;


import java.util.ArrayList;
import java.util.List;

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

    public static List<List<Integer>> findLeaves(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        inorder(list, root);
        return list;
    }

    // traverse the tree bottom-up recursively
    private static int inorder(List<List<Integer>> list, Node root) {
        if (root == null) {
            return -1;
        }
        int left    = inorder(list, root.left);
        int right   = inorder(list, root.right);
        int height  = Math.max(left, right) + 1;
        // the first time this code is reached is when height = 0, since the tree is bottom-up processed.
        if (list.size() <= height) {
            list.add(new ArrayList<>());
        }
        list.get(height).add(root.num);
        return height;
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
