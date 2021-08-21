package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class RootToLeafPathSum {

    public static boolean pathExist(Node root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        return pathExist(root.left, sum - root.num) || pathExist(root.right, sum - root.num);
    }

    public static void findPath(Node root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum += root.num;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return;
        }
        findPath(root.left, sum, list);
        findPath(root.right, sum, list);
    }

    public static void main(String[] args) {
        int[] a = {20, 10, 30, 5};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(pathExist(root, 30));
        List<Integer> list = new ArrayList<>();
        findPath(root, 0, list);
        System.out.println(list);
    }
}
