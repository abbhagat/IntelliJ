package trees;

import java.util.ArrayList;
import java.util.List;

import static trees.CreateBST.createBST;

public class PrintAllNodesAtKDistanceFromRoot {

    private static List<Integer> list = new ArrayList<>();

    private static List<Integer> printNodes(Node root, int level) {
        if (root == null) {
            return null;
        }
        if (level == 0) {
            list.add(root.num);
        }
        if (level > 0) {
            printNodes(root.left, level - 1);
            printNodes(root.right, level - 1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 6, 2, 0, 8, 7, 4};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(printNodes(root, 2));
    }
}
