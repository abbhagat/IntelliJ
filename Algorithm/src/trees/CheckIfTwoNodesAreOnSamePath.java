package trees;

import java.util.LinkedList;

public class CheckIfTwoNodesAreOnSamePath {
    private static boolean isOnSamePath(Node root, int num1, int num2, LinkedList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.num);
        if (root.left == null && root.right == null) {
            return list.contains(num1) && list.contains(num2);
        }
        boolean x = isOnSamePath(root.left, num1, num2, list);
        if (!x) {
            list.removeLast();
            return isOnSamePath(root.right, num1, num2, list);
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
