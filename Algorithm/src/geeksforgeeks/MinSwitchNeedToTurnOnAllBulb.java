package geeksforgeeks;

/**
A wire connects n light bulbs. Each bulb has a switch associated with it; however, due to faulty wiring,
a switch also changes the state of all the bulbs to the right of the current bulb.
Given the initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.
Note: 0 represents the bulb is off and 1 represents the bulb is on.
Example: - Input : [0 1 0 1] Output: 4
Explanation:-
press switch 0: [1 0 1 0]
press switch 1: [1 1 0 1]
press switch 2: [1 1 1 0]
press switch 3: [1 1 1 1]
*/

public class MinSwitchNeedToTurnOnAllBulb {

    private static int solve(int[] a) {
        int state = 0, count = 0;
        for (int x : a) {
            if (x == state) {
                state ^= 1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{0, 1, 0, 1}));
        System.out.println(solve(new int[]{1, 0, 0, 0}));
        System.out.println(solve(new int[]{1, 1, 1, 1}));
        System.out.println(solve(new int[]{1, 1, 1, 0}));
    }
}
