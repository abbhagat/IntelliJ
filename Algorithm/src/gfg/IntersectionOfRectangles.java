package gfg;


public class IntersectionOfRectangles {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

        if (l1.x == r1.x || l1.y == r1.y || l2.x == r2.x || l2.y == r2.y) {  // To check if either rectangle is actually a line
            return false;
        }
        if (l1.x >= r2.x || l2.x >= r1.x) {    // If one rectangle is on left side of other
            return false;
        }
        if (l1.y <= r2.y || l2.y <= r1.y) {   // If one rectangle is above other
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Point l1 = new Point(0, 10);
        Point l2 = new Point(5, 5);
        Point l3 = new Point(15, 15);
        Point r1 = new Point(10, 0);
        Point r2 = new Point(15, 0);
        Point r3 = new Point(15, 10);
        System.out.println(doOverlap(l1, r1, l2, r2) ? "Overlap" : "Don't Overlap");
        System.out.println(doOverlap(l1, r1, l3, r3) ? "Overlap" : "Don't Overlap");
    }
}
