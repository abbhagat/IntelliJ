package trees;

public class HeightDiffOfTwoNodes {

    public static void main(String[] args) {
        int[] a = { 10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7 };
        BST root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        int num1 = 13, num2 = 6;
        SearchBST search = new SearchBST();
        BST root1 = search.searchBST(root, num1);
        BST root2 = search.searchBST(root, num2);
        TreeHeight th1 = new TreeHeight();
        th1.height(root1);
        int height1 = th1.treeHeight(root1);
        TreeHeight th2 = new TreeHeight();
        th2.height(root2);
        int height2 = th2.treeHeight(root2);
        System.out.println(Math.abs(height1 - height2));
    }
}
