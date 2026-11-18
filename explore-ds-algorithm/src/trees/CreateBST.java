package trees;

public class CreateBST {

  public static Node createBST(Node root, int num) {
    if (root == null) {
      root = new Node(num);
    } else if (num < root.num) {
      root.left = createBST(root.left, num);
    } else if (num > root.num) {
      root.right = createBST(root.right, num);
    }
    return root;
  }
}
