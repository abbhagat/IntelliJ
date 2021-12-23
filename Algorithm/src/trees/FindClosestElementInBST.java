package trees;

/*
Input:
                                                10
                                              /   \
                                             2    11
                                           /  \
                                          1    5
                                              /  \
                                             3    6
                                              \
                                               4
K = 13 Output: 2
Explanation: K=13. The node that has value nearest to K is 11. so the answer is 2
*/

import static java.lang.Math.abs;

public class FindClosestElementInBST {

    private static int closest = Integer.MAX_VALUE;
    private static Node node;

    private static void findClosest(Node root, int k, int closest) {
        if (root != null) {
            int diff = abs(root.num - k);
            if (diff < closest) {
                closest = diff;
                node = root;
            }
            findClosest(root.left, k, closest);
            findClosest(root.right, k, closest);
        }
    }

    public static void main(String[] args) {
        Node root                   = new Node(10);
        root.left                   = new Node(2);
        root.right                  = new Node(11);
        root.left.left              = new Node(1);
        root.left.right             = new Node(5);
        root.left.right.left        = new Node(3);
        root.left.right.right       = new Node(6);
        root.left.right.left.right  = new Node(4);
        int k = 13;
        findClosest(root, k, Integer.MAX_VALUE);
        System.out.println(node == null ? "null" : abs(node.num - k));
    }
}
