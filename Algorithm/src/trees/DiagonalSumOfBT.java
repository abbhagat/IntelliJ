package trees;

import java.util.*;

public class DiagonalSumOfBT {

    private static class Node {
        int num, vd = Integer.MAX_VALUE;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }
    }

    private static void rightDiagonalSumOfBT(Node root) {
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();  // Map to store a sum of node's data lying diagonally
        root.vd = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            int vd = node.vd;
            while (node != null) {
                int prevSum = map.getOrDefault(vd, 0);
                map.put(vd, prevSum + node.num);
                if (node.left != null) {
                    node.left.vd = vd + 1;
                    q.add(node.left);
                }
                node = node.right;
            }
        }
        System.out.println(map.values());
    }

    private static void leftDiagonalSumOfBT(Node root) {
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();  // Map to store sum of node's data lying diagonally
        root.vd = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            int vd = node.vd;
            while (node != null) {
                int prevSum = map.getOrDefault(vd, 0);
                map.put(vd, prevSum + node.num);
                if (node.right != null) {
                    node.right.vd = vd + 1;
                    q.add(node.right);
                }
                node = node.left;
            }
        }
        System.out.println(map.values());
    }

    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left  = new Node(2);
        root.right = new Node(3);
        rightDiagonalSumOfBT(root);
        leftDiagonalSumOfBT (root);
    }
}
