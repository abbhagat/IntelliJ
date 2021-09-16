package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class PrintAllPathFromRootToLeafNodes {

    private static void findPath(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        if (root.left == null && root.right == null) {
            System.out.println(list);
            return;
        }
        findPath(root.left, list);
        list.remove(list.size() - 1);
        findPath(root.right, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        findPath(root, new ArrayList<>());
    }
}
