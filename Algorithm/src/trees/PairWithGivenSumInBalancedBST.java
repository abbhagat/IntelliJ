package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

/*
                     15
                  /     \
                10      20
               / \     /  \
              8  12   16  25
 */

public class PairWithGivenSumInBalancedBST {

    private static List<Integer> inorder(Node root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.num);
            inorder(root.right, list);
        }
        return list;
    }

    private static boolean isPairPresent(Node root, int target) {
        List<Integer> list = inorder(root, new ArrayList<>());
        for (int x : list) {
            int y = target - x;
            if (list.contains(y)) {
                System.out.println(x + "," + y);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {15, 10, 20, 8, 12, 16, 25};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        int target = 33;
        System.out.println(isPairPresent(root, target));
    }
}
