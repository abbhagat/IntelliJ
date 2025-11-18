package trees;

import static trees.CreateBST.createBST;

public class SearchBST {

  public static Node searchBST(Node root, int num) {
    if (root == null) {
      return null;
    }
    if (root.num == num) {
      return root;
    }
    return num < root.num ? searchBST(root.left, num) : searchBST(root.right, num);
  }

  public static boolean searchBST(int num, Node root) {
    if (root == null) {
      return false;
    }
    if (root.num == num) {
      return true;
    }
    return num < root.num ? searchBST(num, root.left) : searchBST(num, root.right);
  }

  public static void main(String[] args) {
    int[] a = {15, 10, 20, 8, 12, 16, 25};
    Node root = null;
    for (int x : a) {
      root = createBST(root, x);
    }
    System.out.println(searchBST(25, root));
  }
}
