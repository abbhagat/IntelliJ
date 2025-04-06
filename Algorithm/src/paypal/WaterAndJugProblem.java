package paypal;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class WaterAndJugProblem {

    private static int gcd(int x, int y) {
        int gcd = 0;
        for (int i = 1; i <= max(x,y); i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

   /*  x -- Capacity of jug from which water is poured
       y -- Capacity of jug to which water is poured
       z -- Amount to be measured
   */
    public static int minSteps(int x, int y, int z) {
        int from = x, to = 0, step = 1;
        while (from != z && to != z) {            // Break the loop when either of the two jugs has d litre water
            int temp = min(from, y - to);    //  Find the maximum amount that can be poured
            to   = to   + temp;                 //   Pour "temp" liters from "from" to "to"
            from = from - temp;
            step++;
            if (from == z || to == z) {
                break;
            }
            if (from == 0) {    // If first jug becomes empty, fill it
                from = x;
                step++;
            }
            if (to == y) {      // If second jug becomes full, empty it
                to = 0;
                step++;
            }
        }
        return step;
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
        System.out.println(canMeasure(3, 5, 4) ? min(minSteps(3, 5, 4), minSteps(5, 3, 4)) : "Not Possible");
        System.out.println(canMeasure(5, 3, 3) ? min(minSteps(3, 5, 3), minSteps(5, 3, 3)) : "Not Possible");
    }
}
