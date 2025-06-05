package trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static trees.CreateBST.createBST;

/*
                     15
                  /     \
                10      20
               / \     /  \
              8  12   16  25
 */

public class PairWithGivenSumInBalancedBST {

    private static Set<Integer> inorder(Node root, Set<Integer> set) {
        if (root != null) {
            inorder(root.left, set);
            set.add(root.num);
            inorder(root.right, set);
        }
        return set;
    }

    private static void isPairPresent(Node root, int target) {
        Set<Integer> set = inorder(root, new HashSet<>());
        for (int x : set) {
             int y = target - x;
             if (set.contains(y) && y > x) {
                 System.out.println(x + "," + y);
             }
         }
    }

    public static void main(String[] args) {
        int[] a = {15, 10, 20, 8, 12, 16, 25};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        isPairPresent(root, 33);
        isPairPresent(root, 25);
    }
}
