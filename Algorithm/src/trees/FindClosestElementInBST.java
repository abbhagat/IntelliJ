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

    static class NodeWrapper {
        Node node;
    }

    private static void findClosest(Node root, int k, int closest, NodeWrapper closetNode) {
        if (root == null) {
            return;
        }
        int diff = abs(root.num - k);
        if (diff < closest) {
            closest = diff;
            closetNode.node = root;
        }
        findClosest(root.left,  k, closest, closetNode);
        findClosest(root.right, k, closest, closetNode);
    }

    public static void main(String[] args) {
        Node root                  = new Node(10);
        root.left                  = new Node(2);
        root.right                 = new Node(11);
        root.left.left             = new Node(1);
        root.left.right            = new Node(5);
        root.left.right.left       = new Node(3);
        root.left.right.right      = new Node(6);
        root.left.right.left.right = new Node(4);
        NodeWrapper closetNode = new NodeWrapper();
        int k = 13;
        findClosest(root, k, Integer.MAX_VALUE, closetNode);
        System.out.println(abs(closetNode.node.num - k));
    }
}
