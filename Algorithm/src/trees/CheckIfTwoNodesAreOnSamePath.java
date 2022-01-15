package trees;

import java.util.LinkedList;

import static trees.CreateBST.createBST;

public class CheckIfTwoNodesAreOnSamePath {

    static class BooleanWrapper {
        boolean flag;
    }

    public static void areOnSamePath(Node root, int num1, int num2, LinkedList<Integer> list, BooleanWrapper booleanWrapper) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        if (root.left == null && root.right == null) {
            if (list.contains(num1) && list.contains(num2)) {
                booleanWrapper.flag = true;
            }
            return;
        }
        areOnSamePath(root.left,  num1, num2, list, booleanWrapper);
        list.removeLast();
        areOnSamePath(root.right, num1, num2, list, booleanWrapper);
        list.removeLast();
    }

    public static void main(String[] args) {
        int[] a = {50, 25, 100, 10, 30, 90, 120};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        BooleanWrapper booleanWrapper = new BooleanWrapper();
        areOnSamePath(root, 25, 10, new LinkedList<>(), booleanWrapper);
        System.out.println(booleanWrapper.flag);
        booleanWrapper = new BooleanWrapper();
        areOnSamePath(root, 25, 90, new LinkedList<>(), booleanWrapper);
        System.out.println(booleanWrapper.flag);
    }
}
