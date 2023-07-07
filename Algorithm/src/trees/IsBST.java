package trees;

import java.util.HashSet;
import java.util.Set;

import static trees.CreateBST.createBST;

// Time Complexity O(n)
public class IsBST {
    private static boolean isBST(Node root, long min, long max, Set<Integer> set) {
        if (root == null) {
            return true;
        }
        if (!set.add(root.num) || root.num < min || root.num > max) {
            return false;
        }
        return isBST(root.left, min, root.num, set) && isBST(root.right, root.num, max, set);
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        System.out.println(isBST(root, Long.MIN_VALUE, Long.MAX_VALUE, new HashSet<>()));
    }
}
