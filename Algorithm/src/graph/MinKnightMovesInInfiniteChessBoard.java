package graph;

import java.util.HashMap;
import java.util.Map;
import static java.lang.Integer.min;
import static java.lang.Math.abs;

// Time  Complexity : O(x × y)
// Space Complexity : O(x × y)
public class MinKnightMovesInInfiniteChessBoard {

  private static final Map<String, Integer> map = new HashMap<>();  // Stores already computed results

  private static int minMoves(int x, int y) {
    String key = x + "," + y;
    if (map.containsKey(key)) {
      return map.get(key);
    }
    if (x + y == 0) {  // Already at origin
      return 0;
    } else if (x + y == 2) {  // This handles tricky cases like: (1,1) (0,2) (2,0) from these coordinates we can move to origin in 2 steps
      return 2;
    } else {
      int n = 1 + min(minMoves(abs(x - 1), abs(y - 2)), minMoves(abs(x - 2), abs(y - 1)));  // Chessboard is symmetric in all quadrants, So we only solve for first quadrant
      map.put(key, n);
      return n;
    }
  }

  private static int minKnightMoves(int x, int y) {
    return minMoves(x, y);
  }

  public static void main(String[] args) {
    System.out.println(minKnightMoves(2, 1)); // [0, 0] --> [2, 1]
    System.out.println(minKnightMoves(5, 5)); // [0, 0] --> [2, 1] --> [4, 2] --> [3, 4] --> [5, 5]
  }
}
