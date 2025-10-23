package trees;

public class SearchBT {

  public static boolean searchBT(Node root, Node node) {
    if (root == null) {
      return false;
    }
    if (root == node) {
      return true;
    }
    return searchBT(root.left, node) || searchBT(root.right, node);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(4);
    root.right.left = new Node(5);
    root.right.right = new Node(6);
    root.right.left.left = new Node(7);
    root.right.right.right = new Node(8);
    System.out.println(searchBT(root, root.right.right) ? "Present" : "Not Present");
  }
}
