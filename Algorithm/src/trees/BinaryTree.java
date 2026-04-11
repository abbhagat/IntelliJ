package trees;

@SuppressWarnings("unused")
public class BinaryTree {

  public static Node createBT(int num, Node root) {
    if (root == null) {
      root = new Node(num);
    } else if (num % 2 == 0) {
      root.left  = createBT(num, root.left);
    } else {
      root.right = createBT(num, root.right);
    }
    return root;
  }

  public static Node createBST() {
         /*
                  4
                /  \
               2    6
              / \  / \
             1  3 5   7
         */
    Node root        = new Node(4);
    root.left        = new Node(2);
    root.right       = new Node(6);
    root.left.left   = new Node(1);
    root.left.right  = new Node(3);
    root.right.left  = new Node(5);
    root.right.right = new Node(7);
    return root;
  }

}
