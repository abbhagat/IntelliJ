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

    private static int findClosest(Node root, int k, int closest, NodeWrapper closetNode) {
        if (root != null) {
            int diff = abs(root.num - k);
            if (diff < closest) {
                closest = diff;
                closetNode.node = root;
            }
            findClosest(root.left, k, closest, closetNode);
            findClosest(root.right, k, closest, closetNode);
        }
        return abs(closetNode.node.num - k);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(11);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);
        root.left.right.left.right = new Node(4);
        System.out.println(findClosest(root, 13, Integer.MAX_VALUE, new NodeWrapper()));
    }
}
