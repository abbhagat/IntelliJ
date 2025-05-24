package paypal;

import static java.lang.Integer.min;
import static util.CommonUtils.gcd;

public class WaterAndJugProblem {

   /*  x -- Capacity of jug from which water is poured
       y -- Capacity of jug to which water is poured
       z -- Amount to be measured
   */
    public static int minSteps(int x, int y, int z) {
        int from = x, to = 0, step = 1;
        while (from != z && to != z) {            // Break the loop when either of the two jugs has z liter water
            int pour = min(from, y - to);    //  Find the maximum amount that can be poured
            to   += pour;                       //   Pour "pour" liters from "from" to "to"
            from -= pour;
            step++;
            if (from == z || to == z) {
                break;
            }
            if (from == 0) { // If the first jug becomes empty, fill it
                from = x;
                step++;
            }
            if (to == y) {  // If the second jug becomes full, empty it
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
        System.out.println(canMeasure(3, 5, 4) ? min(minSteps(3, 5, 4), minSteps(5, 3, 4)) : -1);
        System.out.println(canMeasure(5, 3, 3) ? min(minSteps(3, 5, 3), minSteps(5, 3, 3)) : -1);
    }
}
