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
        if (isOnSamePath(root.left, num1, num2, list)) {
            return true;
        }
        list.removeLast();
        return isOnSamePath(root.right, num1, num2, list);
    }

    private static boolean samePath(Node root, int num1, int num2, LinkedList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.num);
        if (root.left == null && root.right == null) {
            return list.contains(num1) && list.contains(num2);
        }
        boolean x = samePath(root.left, num1, num2, list);
        if (!x) {
            list.removeLast();
            return samePath(root.right, num1, num2, list);
        }
        return true;
    }

    public static void main(String[] args) {
        Node root       = new Node(1);
        root.left       = new Node(2);
        root.right      = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);
        System.out.println(isOnSamePath(root, 1, 2, new LinkedList<>()) + "\t" + samePath(root, 1, 2, new LinkedList<>()));
        System.out.println(isOnSamePath(root, 1, 3, new LinkedList<>()) + "\t" + samePath(root, 1, 3, new LinkedList<>()));
        System.out.println(isOnSamePath(root, 1, 4, new LinkedList<>()) + "\t" + samePath(root, 1, 4, new LinkedList<>()));
        System.out.println(isOnSamePath(root, 4, 5, new LinkedList<>()) + "\t" + samePath(root, 4, 5, new LinkedList<>()));
    }
}
