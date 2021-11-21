package geeks;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class EggDroppingPuzzle {

    private static int eggDrop(int eggs, int floor) {
        if (floor == 0 || floor == 1) {
            return floor;
        }
        if (eggs == 1) {
            return floor;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {
            int result = max(eggDrop(eggs - 1, i - 1), eggDrop(eggs, floor - i));
            min = min(min, result);
        }
        return min + 1;
    }

    public static void main(String args[]) {
        int egg = 2, floor = 10;
        System.out.print("Minimum number of trials in worst case with " + egg + " eggs and " + floor + " floors is " + eggDrop(egg, floor));
    }
}
