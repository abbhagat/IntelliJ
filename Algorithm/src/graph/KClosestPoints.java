package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a list of points on a 2D plane. Find k closest points to the origin (0, 0).
 * Input: [(1, 1), (2, 2), (3, 3)], 1
 * Output: [(1, 1)]
 */

// Time  Complexity : O(n log k)
// Space Complexity : O(k)
public class KClosestPoints {

  private static int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];  // We don't need the actual distance (sqrt) because comparing squared distances gives the same ordering.
  }

  // The heap stores at most k points. The farthest among those k points stays at the top, so whenever we find a closer point, we remove the farthest one.
  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));  // Max heap based on distance from origin
    for (int[] point : points) {
      pq.add(point);
      if (pq.size() > k) {  // Keep only k closest points
        pq.poll();
      }
    }
    int[][] M = new int[k][2];
    for (int i = 0; i < k; i++) {
      M[i] = pq.poll();
    }
    return M;
  }

  public static void main(String[] args) {
    int[][] points = {
                        {1, 1},
                        {2, 2},
                        {3, 3}
                     };
    System.out.println(Arrays.deepToString(kClosest(points, 1)));
  }
}
