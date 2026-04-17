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
    rightDiagonalSumOfBT(node.left, diagonal + 1, map); // Left child → next diagonal  When you move left, you go down to the next diagonal line.
    rightDiagonalSumOfBT(node.right, diagonal, map);              // Right child → same diagonal When you move right, you stay on the same slanted line. From 1 → 3 → 7
  }

  public static void main(String[] args) {
    rightDiagonalSumOfBT(createBST());
  }
}
