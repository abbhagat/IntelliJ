package trees;

import java.util.HashMap;
import java.util.Map;
import static trees.BinaryTree.createBST;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class LeftDiagonalSumOfBT {

  private static void leftDiagonalSum(Node root) {
    Map<Integer, Integer> map = new HashMap<>();
    leftDiagonalSum(root, 0, map);
    System.out.println(map.values());
  }

  private static void leftDiagonalSum(Node root, int diagonal, Map<Integer, Integer> map) {
    if(root == null) {
      return;
    }
    int prevDiagonalSum = map.getOrDefault(diagonal, 0);
    map.put(diagonal, prevDiagonalSum + root.num);
    leftDiagonalSum(root.left, diagonal, map);
    leftDiagonalSum(root.right, diagonal + 1, map);
  }

  public static void main(String[] args) {
    leftDiagonalSum(createBST());
  }
}
