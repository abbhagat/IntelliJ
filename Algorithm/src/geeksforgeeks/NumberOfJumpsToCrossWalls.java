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
        int jumps = 0;
        for (int i = 0; i < a.length; ) {
            if (x >= a[i]) {
                jumps++;
                i++;
            } else {
                jumps++;
                a[i] = a[i] - x + y;
            }
        }
        return jumps;
    }


    public static void main(String[] args) {
        System.out.println(findJumps(new int[]{11}, 10, 1));
        System.out.println(findJumps(new int[]{11, 11}, 10, 1));
        System.out.println(findJumps(new int[]{11, 10, 10, 9}, 10, 1));
        // Below code is the scenario for single case
        int height = 11;
        int jumps = 0;
        int x = 10, y = 1;
        while (true) {
            if (x >= height) {
                jumps++;
                break;
            } else {
                jumps++;
                height = height - x + y;
            }
        }
        System.out.println(jumps);
    }
}
