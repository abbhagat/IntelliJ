package trees;

import java.util.LinkedList;

public class CheckIfTwoNodesAreOnSamePath {
    private static boolean isOnSamePath(Node root, int x, int y, LinkedList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.num);
        if (list.contains(x) && list.contains(y)) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return list.contains(x) && list.contains(y);
        }
        boolean isOnSamePath = isOnSamePath(root.left, x, y, list);
        if (!isOnSamePath) {
            list.removeLast();
            return isOnSamePath(root.right, x, y, list);
        }
        return true;
    }

    public static void main(String[] args) {
        Node root       = new Node(1);
        root.left       = new Node(2);
        root.right      = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        LinkedList<Integer> list;

        list = new LinkedList<>();
        System.out.println(isOnSamePath(root, 1, 2, list) + "\t" + list);

        list = new LinkedList<>();
        System.out.println(isOnSamePath(root, 1, 3, list) + "\t" + list);

        list = new LinkedList<>();
        System.out.println(isOnSamePath(root, 1, 4, list) + "\t" + list);

        list = new LinkedList<>();
        System.out.println(isOnSamePath(root, 4, 5, list) + "\t" + list);
    }
}
