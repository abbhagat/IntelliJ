package paypal;

public class WaterAndJugProblem {

    private static int gcd(int x, int y) {
        return (y % x == 0) ? x : gcd(y % x, x);
    }

    /* fromCap -- Capacity of jug from which water is poured
       toCap   -- Capacity of jug to which water is poured
       d       -- Amount to be measured
   */
    public static int pour(int fromCap, int toCap, int d) {
        int from = fromCap, to = 0, step = 1;
        while (from != d && to != d) {               // Break the loop when either of the two jugs has d litre water
            int temp = Math.min(from, toCap - to);  // Find the maximum amount that can be poured
            to += temp;                            // Pour "temp" liters from "from" to "to"
            from -= temp;
            step++;
            if (from == d || to == d) {
                break;
            }
            if (from == 0) {                    // If first jug becomes empty, fill it
                from = fromCap;
                step++;
            }
            if (to == toCap) {                // If second jug becomes full, empty it
                to = 0;
                step++;
            }
        }
        return step;
    }

    public static int minSteps(int m, int n, int d) {
        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }
        if (d > n) {                // For d > n we cant measure the water using the jugs
            return -1;
        }
        if ((d % gcd(n, m)) != 0) {   // If gcd of n and m does not divide d then solution is not possible
            return -1;
        }
        // Return minimum two cases:
        // a) Water of n liter jug is poured into m liter jug
        // b) Vice versa of "a"
        return Math.min(pour(n, m, d), pour(m, n, d));
    }

    public static void main(String[] args) {
        int n = 3, m = 5, d = 4;
        System.out.println(minSteps(m, n, d));
    }
}
