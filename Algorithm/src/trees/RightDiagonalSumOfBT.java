package trees;

import java.util.HashMap;
import java.util.Map;
import static trees.BinaryTree.createBST;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class RightDiagonalSumOfBT {

  private static void rightDiagonalSumOfBT(Node root) {
    Map<Integer, Integer> map = new HashMap<>();
    rightDiagonalSumOfBT(root, 0, map);     // diagonal tells us which diagonal the current node belongs to.
    System.out.println(map.values());
  }

  private static void rightDiagonalSumOfBT(Node root, int diagonal, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }
    map.put(diagonal, map.getOrDefault(diagonal, 0) + root.num); // Add current node value to its diagonal
    rightDiagonalSumOfBT(root.left, diagonal + 1, map); // Left child → next diagonal  When you move left, you go down to the next diagonal line.
    rightDiagonalSumOfBT(root.right, diagonal, map);              // Right child → same diagonal When you move right, you stay on the same slanted line. From 1 → 3 → 7
  }

  public static void main(String[] args) {
    rightDiagonalSumOfBT(createBST());
  }
}
