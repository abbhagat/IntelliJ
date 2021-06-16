package geeks;

/*
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
        if (sx > dx || sy > dy) {  // base case
            return false;
        }
        if (sx == dx && sy == dy) {  // current point is equal to destination
            return true;
        }
        return (isReachable(sx, sx + sy, dx, dy) || isReachable(sx + sy, sy, dx, dy));  // check for other 2 possibilities
    }

    public static void main(String[] args) {
        int sx = 2, sy = 10, dx = 26, dy = 12;
        System.out.print(isReachable(sx, sy, dx, dy) ? "Reachable" : "Not Reachable");
    }
}
