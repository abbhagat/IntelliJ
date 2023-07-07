package recursion;

/**
   Given coordinates of a source point (x1, y1) determine if it is possible to reach the destination point (x2, y2).
   From any point (x, y) there only two types of valid movements:
   (x, x + y) and (x + y, y). Return a boolean true if it is possible else return false.
   Note: All coordinates are positive.

   Input : (x1, y1) = (2, 10)
           (x2, y2) = (26, 12)
   Output : True
            (2, 10)->(2, 12)->(14, 12)->(26, 12) is a valid path.
   Input : (x1, y1) = (20, 10)
           (x2, y2) = (6, 12)
   Output : False
   No such path is possible because x1 > x2 and coordinates are positive
 */

public class DestinationReachableWith2MovesAllowed {
    private static boolean isReachable(int sx, int sy, int dx, int dy) {
        if (sx > dx || sy > dy) {
            return false;
        }
        if (sx == dx && sy == dy) {
            return true;
        }
        return isReachable(sx, sx + sy, dx, dy) || isReachable(sx + sy, sy, dx, dy);
    }

    // Time Complexity: O(1)
    // Auxiliary Space: O(1)
    private static boolean isReachable(long x1, long y1, long x2, long y2) {
        while (x2 > x1 && y2 > y1) {
            if (x2 > y2) {
                x2 %= y2;    // Reduce x2 by y2 until it is less than or equal to x1
            } else {
                y2 %= x2;   //  Reduce y2 by x2 until it is less than or equal to y1
            }
        }
        long x = x2 - x1, y = y2 - y1;
        if (x2 == x1) {                                      // If x2 is reduced to x1
            return y >= 0 && y % x1 == 0;   // Check if y2 can be reduced to y1 or not
        }
        if (y2 == y1) {                                    // If y2 is reduced to y1
            return x >= 0 && x % y1 == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isReachable(2, 10, 26, 12)     ? "Reachable" : "Not Reachable");
        System.out.println(isReachable(2L, 10L, 26L, 12L) ? "Reachable" : "Not Reachable");
        System.out.println(isReachable(20, 10, 6, 12)     ? "Reachable" : "Not Reachable");
        System.out.println(isReachable(20L, 10L, 6L, 12L) ? "Reachable" : "Not Reachable");
    }
}
