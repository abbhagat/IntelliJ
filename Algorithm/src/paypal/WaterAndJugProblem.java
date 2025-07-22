package paypal;

import static java.lang.Integer.min;
import static util.CommonUtils.gcd;

public class WaterAndJugProblem {

/*
    x - Capacity of jug from which water is poured.
    y - Capacity of jug to which water is poured.
    z - Amount to be measured.
*/
    public static int minSteps(int x, int y, int z) {
        if (z > x && z > y || z % gcd(x, y) != 0) {
            return -1;
        }
        int from = 0, to = 0, steps = 0, pour;
        while (from != z && to != z) {
            if (from == 0) {
                from = x;                  // Fill jug x
            } else if (to == y) {
                to = 0;                   // Empty jug y
            } else {
                pour  = min(from, y - to);
                from -= pour;
                to   += pour;
            }
            steps++;
        }
        return steps;
    }

    private static boolean canMeasure(int x, int y, int z) {
        return (z <= x || z <= y) && z % gcd(x, y) == 0;
    }

    public static void main(String[] args) {
        System.out.println(canMeasure(3, 5, 4) ? min(minSteps(3, 5, 4), minSteps(5, 3, 4)) : -1);
        System.out.println(canMeasure(5, 3, 3) ? min(minSteps(3, 5, 3), minSteps(5, 3, 3)) : -1);
    }
}
