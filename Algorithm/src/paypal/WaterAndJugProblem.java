package paypal;

import static java.lang.Integer.min;

public class WaterAndJugProblem {

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    private static int hcf(int x, int y) {
        int hcf = 0;
        for (int i = 1; i <= x || i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                hcf = i;
            }
        }
        return hcf;
    }

    /* x -- Capacity of jug from which water is poured
       y -- Capacity of jug to which water is poured
       z -- Amount to be measured
   */
    public static int pour(int x, int y, int z) {
        int from = x, to = 0, step = 1;
        while (from != z && to != z) {          // Break the loop when either of the two jugs has d litre water
            int temp = min(from, y - to);    // Find the maximum amount that can be poured
            to += temp;                         // Pour "temp" liters from "from" to "to"
            from -= temp;
            step++;
            if (from == z || to == z) {
                break;
            }
            if (from == 0) {                    // If first jug becomes empty, fill it
                from = x;
                step++;
            }
            if (to == y) {                // If second jug becomes full, empty it
                to = 0;
                step++;
            }
        }
        return step;
    }

    public static int minSteps(int x, int y, int z) {
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        if (z > y) {                // For d > n we cant measure the water using the jugs
            return -1;
        }
        if ((z % gcd(x, y)) != 0) {   // If gcd of n and m does not divide d then solution is not possible
            return -1;
        }
        // Return minimum two cases:
        // a) Water of n liter jug is poured into m liter jug
        // b) Vice versa of "a"
        return min(pour(x, y, z), pour(y, x, z));
    }

    private static boolean canMeasure(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % gcd(x, y) == 0;
    }

    public static void main(String[] args) {
        System.out.println(canMeasure(3, 5, 4) ? minSteps(3, 5, 4) : "Not Possible");
        System.out.println(canMeasure(3, 5, 3) ? minSteps(3, 5, 3) : "Not Possible");
    }
}
