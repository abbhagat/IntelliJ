package trees;

import java.util.LinkedList;
import java.util.Queue;
import static java.lang.Integer.max;
import static trees.BinaryTree.createBST;

/*
Constructed Binary tree is:
                    1
                  /   \
                2      3
              /  \    /  \
             4    5  6    7
                         / \
                        8   9
*/
// Time  Complexity : O(n)
// Space Complexity : O(2^h)
public class BinaryTreeMaxWidth {

  private static int findMaxWidth(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int width = 0, maxWidth = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size != 0) {
        Node node = q.poll();
        if (node != null) {
          if (node.left != null) {
            q.add(node.left);
          }
          if (node.right != null) {
            q.add(node.right);
          }
          width++;
          size--;
        }
      }
      maxWidth = max(maxWidth, width);
      width = 0;
    }
    return maxWidth;
  }

  public static void main(String[] args) {
    Node root = createBST();
    System.out.println("Maximum Width = " + findMaxWidth(root));
  }
}
