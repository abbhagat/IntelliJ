package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class RootToLeafLongestPath {

    public static List<Integer> longestPath(Node root) {
        if (root == null) {                                  // If root is null means there is no binary tree so return a empty list
            return new ArrayList<>();
        }
        List<Integer> left = longestPath(root.left);      // Recursive call on root.left
        List<Integer> right = longestPath(root.right);   // Recursive call on root.right
        boolean b = right.size() < left.size() ? left.add(root.num) : right.add(root.num); // Compare the size of the two ArrayList and insert current node accordingly
        return left.size() > right.size() ? left : right;  // Return the appropriate ArrayList
    }

    public static void main(String[] args) {
        int[] a = {20, 10, 30, 5};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(longestPath(root));
    }
}
