package trees;

import java.util.*;
import static trees.BinaryTree.createBST;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class RightDiagonalSumOfBT {

  private static void rightDiagonalSumOfBT(Node root) {
    Map<Integer, Integer> map = new TreeMap<>();                          // use TreeMap to print diagonals in order
    rightDiagonalSumOfBT(root, 0, map);
    System.out.println(map.values());
  }

  private static void rightDiagonalSumOfBT(Node node, int diagonal, Map<Integer, Integer> map) {
    if (node == null) {
      return;
    }
    int prevDiagonalSum = map.getOrDefault(diagonal, 0);
    map.put(diagonal, prevDiagonalSum + node.num);                 // Add current node value to its diagonal
    rightDiagonalSumOfBT(node.left, diagonal + 1, map); // Left child → next diagonal
    rightDiagonalSumOfBT(node.right, diagonal, map);              // Right child → same diagonal
  }

  public static void main(String[] args) {
    Node root  = createBST();
    rightDiagonalSumOfBT(root);
  }

}
