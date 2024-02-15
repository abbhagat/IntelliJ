package trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalSumOfBT {

    private static class Node {
        int num, vd = Integer.MAX_VALUE;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }
    }

    private static void diagonalSumOfBT(Node root) {
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();  // Map to store sum of node's data lying diagonally
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
        map.forEach((k, v) -> System.out.println(v));
    }

    public static void main(String[] args) {
        Node root             = new Node(1);
        root.left             = new Node(2);
        root.right            = new Node(3);
        diagonalSumOfBT(root);
    }
}
