package trees;

import static trees.CreateBST.createBST;
import static trees.SearchBST.searchBST;
import static trees.TreeHeight.treeHeight;

public class HeightDifferenceOfTwoNodes {

    public static void main(String[] args) {
        int[] a = {10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        int num1 = 13, num2 = 6;
        Node root1  = searchBST(root, num1);
        Node root2  = searchBST(root, num2);
        int height1 = treeHeight(root1);
        int height2 = treeHeight(root2);
        System.out.println(Math.abs(height1 - height2));
    }
}
