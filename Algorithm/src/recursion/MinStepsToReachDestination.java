package recursion;

import static java.lang.Integer.min;

/*
  Given a number line from -infinity to +infinity. You start at 0 and can go either to the left or to the right.
  The condition is that in i’th move, you take i steps.
  a) Find if you can reach a given number x
  b) Find the most optimal way to reach a given number x, if we can indeed reach it.
  For example, 3 can be reached in 2 steps, (0, 1) (1, 3) and 4 can be reached in 3 steps (0, -1), (-1, 1) (1, 4).
  The important thing to note is we can reach any destination as it is always possible to make a move of length 1.
  At any step i, we can move forward i, then backward i + 1.
  1) Since distance of + 5 and – 5 from 0 is same, hence we find answer for absolute value of destination.
  2) We use a recursive function which takes as arguments:
  i) Source Vertex
  ii) Value of last step taken
  iii) Destination
  3) If at any point source vertex = destination; return number of steps.
  4) Otherwise we can go in both of the possible directions. Take the minimum of steps in both cases.
  From any vertex we can go to :
  (current source + last step +1) and
  (current source – last step -1)
 */

// Time Complexity : O(2^n)
// Auxiliary Space : O(2^n)
public class MinStepsToReachDestination {

    private static int minSteps(int source, int steps, int dest) {
        if (Math.abs(source) > dest) {
            return Integer.MAX_VALUE;
        }
        if (source == dest) {
            return steps;
        }
        steps++;
        int pos = minSteps(source + steps, steps, dest);
        int neg = minSteps(source - steps, steps, dest);
        return min(pos, neg);
    }

    public static void main(String[] args) {
        System.out.println("Steps required" + " to reach " + 3 + " is " + minSteps(0, 0, 3));
        System.out.println("Steps required" + " to reach " + 5 + " is " + minSteps(0, 0, 5));
    }
}
