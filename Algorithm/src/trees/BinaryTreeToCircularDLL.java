package trees;

// Time  Complexity : O(n)
// Space Complexity : O(log n)
public class BinaryTreeToCircularDLL {

  private static Node temp, head;

  private static void convertTreeToDLL(Node root) {
    if (root == null) {
      return;
    }
    convertTreeToDLL(root.left);
    if (head == null) {
      head = root;
    } else {
      temp.right = root;
      root.left = temp;
    }
    temp = root;
    convertTreeToDLL(root.right);
  }

  public static void main(String[] args) {
    Node root  = new Node(2);
    root.left  = new Node(1);
    root.right = new Node(3);
    convertTreeToDLL(root);
    temp.right = head;
    head.left  = temp;
    temp = head;
    do {
      System.out.print(temp.num + " ");
      temp = temp.right;
    } while (temp != head);
  }
}
