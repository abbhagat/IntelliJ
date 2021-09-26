package trees;

import java.util.LinkedList;

import static trees.CreateBST.createBST;

public class PrintAllPathFromRootToLeafNodes {

    private static void findPath(Node root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        if (root.left == null && root.right == null) {
            System.out.println(list);
            return;
        }
        findPath(root.left, list);
        list.removeLast();
        findPath(root.right, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        findPath(root, new LinkedList<>());
    }
}
