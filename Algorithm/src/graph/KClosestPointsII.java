package graph;

import util.Point;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a list of points on a 2D plane. Find k closest points to the origin (0, 0).
 * Input: [(1, 1), (2, 2), (3, 3)], 1
 * Output: [(1, 1)]
 */
// Time  Complexity : O(n log k)
// Space Complexity : O(k)
public class KClosestPointsII {

  private static int distance(Point point) {
    return point.x * point.x + point.y * point.y;  // We don't need the actual distance (sqrt) because comparing squared distances gives the same ordering.
  }

  // The heap stores at most k points. The farthest among those k points stays at the top, so whenever we find a closer point, we remove the farthest one.
  public static Point[] kClosest(Point[] points, int k) {
    PriorityQueue<Point> pq = new PriorityQueue<>((pointA, pointB) -> Integer.compare(distance(pointB), distance(pointA))); // Max heap based on distance from origin
    for (Point point : points) {
      pq.add(point);
      if (pq.size() > k) {  // Keep only k closest points
        pq.poll();
      }
    }
    Point[] point = new Point[k];
    for (int i = 0; i < k; i++) {
      point[i] = pq.poll();
    }
    return point;
  }

  public static void main(String[] args) {
    Point[] points = new Point[]{ new Point(1, 1), new Point(2, 2),new Point(3, 3)};
    System.out.println(Arrays.deepToString(kClosest(points, 1)));
  }
}
