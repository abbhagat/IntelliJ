package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class PrintAllPathsFromRootToNodeWhichAreAtKDistanceFromRoot {

    private static void findPath(Node root, int k, List<Integer> list, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        if (k == 0) {
            System.out.println(list);
            List<Integer> path = new ArrayList<>();
            path.addAll(list);
            lists.add(path);
            return;
        }
        findPath(root.left, k - 1, list, lists);
        list.remove(list.size() - 1);
        findPath(root.right, k - 1, list, lists);
        list.remove(list.size() - 1);
    }

    private static void printAllPathsFromRootWhichAreAtKDistance(Node root, int k, List<Integer> list) {
        List<List<Integer>> lists = new ArrayList<>();
        findPath(root, k, list, lists);
        System.out.println(lists);
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        printAllPathsFromRootWhichAreAtKDistance(root, 2, new ArrayList<>());
    }
}
