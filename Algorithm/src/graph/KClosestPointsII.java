package graph;

import util.Point;

import java.util.PriorityQueue;

public class KClosestPointsII {

  private static int distance(Point point) {
    return point.x * point.x + point.y * point.y;  // We don't need the actual distance (sqrt) because comparing squared distances gives the same ordering.
  }

  public static void main(String[] args) {
    // The heap stores at most k points. The farthest among those k points stays at the top, so whenever we find a closer point, we remove the farthest one.
    PriorityQueue<Point> pq = new PriorityQueue<>((pointA, pointB) -> Integer.compare(distance(pointB), distance(pointA)));
  }
}
