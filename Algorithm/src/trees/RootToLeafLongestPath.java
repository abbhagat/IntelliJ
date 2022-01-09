package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class RootToLeafLongestPath {

    public static List<Integer> longestPath(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leftList  = longestPath(root.left);
        List<Integer> rightList = longestPath(root.right);
        boolean b = leftList.size() > rightList.size() ? leftList.add(root.num) : rightList.add(root.num);
        return      leftList.size() > rightList.size() ? leftList : rightList;
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
