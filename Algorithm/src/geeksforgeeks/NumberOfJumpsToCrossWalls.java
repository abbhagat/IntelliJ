package geeksforgeeks;

/**
 * A thief trying to escape from a jail. He has to cross N walls each with varying heights (every height is greater than 0).
 * He climbs X feet every time. But, due to the slippery nature of those walls, every time he slips back by Y feet.
 * Now the task is to calculate the total number of jumps required to cross all walls and escape from the jail.
 * Examples :
 * Input : heights[] = {11, 11}
 * X = 10;
 * Y = 1;
 * Output : 4
 * He needs to make 2 jumps for first wall and 2 jumps for second wall.
 * <p>
 * Input : heights[] = {11, 10, 10, 9}
 * X = 10;
 * Y = 1;
 * Output : 5
 */

public class NumberOfJumpsToCrossWalls {

    private static int findJumps(int[] a, int x, int y) {
        int i =0, jumps = 0;
        while (i < a.length) {
            if (a[i] > x) {
                a[i] -= x + y;
            } else {
                i++;
            }
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(findJumps(new int[]{11}, 10, 1));
        System.out.println(findJumps(new int[]{11, 11}, 10, 1));
        System.out.println(findJumps(new int[]{11, 10, 10, 9}, 10, 1));
        // Below code is the scenario for single case
        int height = 11, x = 10, y = 1, jumps = 0;
        if (height <= x) {
            System.out.println(1);
        } else {
            while (height > x) {
                height -= x + y;
                jumps++;
            }
        }
        System.out.println(jumps);
    }
}
