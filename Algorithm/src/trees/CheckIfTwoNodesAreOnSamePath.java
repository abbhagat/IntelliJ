package trees;

import java.util.LinkedList;

import static trees.CreateBST.createBST;

public class CheckIfTwoNodesAreOnSamePath {

    private static boolean flag;

    public static void areOnSamePath(Node root, int num1, int num2, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        if (root.left == null && root.right == null) {
            if(list.contains(num1) && list.contains(num2)) {
                flag = true;
            }
            return;
        }
        areOnSamePath(root.left, num1, num2, list);
        list.removeLast();
        areOnSamePath(root.right, num1, num2, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        flag = false;
        areOnSamePath(root, 25, 10, new LinkedList<>());
        System.out.println(flag);
        flag = false;
        areOnSamePath(root, 25, 90, new LinkedList<>());
        System.out.println(flag);
    }
}
