package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class RootToLeafPathSum {

    public static boolean pathExist(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.num) {
            return true;
        }
        return (sum - root.num < root.num) ? pathExist(root.left, sum - root.num) : pathExist(root.right, sum - root.num);
    }

    public static void findPath(Node root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        if (sum == root.num) {
            System.out.println(list);
            return;
        } else if (sum - root.num < root.num) {
            findPath(root.left, sum - root.num, list);
        } else if (sum - root.num > root.num) {
            findPath(root.right, sum - root.num, list);
        }
    }

    public static void rootToLeafPathSum(Node root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum += root.num;
        if (root.left == null && root.right == null) {
            list.add(sum);
            return;
        }
        rootToLeafPathSum(root.left,  sum, list);
        rootToLeafPathSum(root.right, sum, list);
    }

    public static void main(String[] args) {
        int[] a = {20, 10, 30, 5, 2, 9, 25, 50};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(pathExist(root, 35));
        List<Integer> list = new ArrayList<>();
        rootToLeafPathSum(root, 0, list);
        System.out.println(list);
        findPath(root, 35, new ArrayList<>());
    }
}
