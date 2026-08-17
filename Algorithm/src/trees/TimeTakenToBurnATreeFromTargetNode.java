package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TimeTakenToBurnATreeFromTargetNode {

  private static final Queue<Node> q = new LinkedList<>();
  private static int time;

  private static int burnTree(Node root, int target) {
    if (root == null) {
      return -1;
    }
    if (root.num == target) {
      time++;
      if (root.left != null) {
        q.add(root.left);
      }
      if (root.right != null) {
        q.add(root.right);
      }
      return 0;
    }
    int leftCall = burnTree(root.left, target);
    if (leftCall == 0) {
      printQueue();
      time++;
      if (root.right != null) {
        q.add(root.right);
      }
      return 0;
    }
    int rightCall = burnTree(root.right, target);
    if (rightCall == 0) {
      printQueue();
      if (root.left != null) {
        q.add(root.left);
      }
      time++;
      return 0;
    }
    return -1;
  }

  private static void printQueue() {
    int size = q.size();
    while (size != 0) {
      Node root = q.poll();
      if (root.left != null) {
        q.add(root.left);
      }
      if (root.right != null) {
        q.add(root.right);
      }
      size--;
    }
  }

  public static void main(String[] args) {
        /*
                    12
                  /   \
                 13     10
                       /  \
                     14    15
                   /  \   /  \
                  21  24 22   23
         */
    Node root              = new Node(12);
    root.left              = new Node(13);
    root.right             = new Node(10);
    root.right.left        = new Node(14);
    root.right.right       = new Node(15);
    root.right.left.left   = new Node(21);
    root.right.left.right  = new Node(24);
    root.right.right.left  = new Node(22);
    root.right.right.right = new Node(23);
    burnTree(root, 14);
    while (!q.isEmpty()) {
      printQueue();
      time++;
      System.out.println();
    }
    System.out.println("Time taken to burn the tree is : " + time);
  }
}
