package recursion;

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
public class MinStepsToReachDestination {

    /*    Function to count number of steps required to reach a destination
          source -> source vertex
          step -> value of last step taken
          dest -> destination vertex
    */
    private static int steps(int source, int step, int dest) {
        if (Math.abs(source) > dest) {  // base cases
            return Integer.MAX_VALUE;
        }
        if (source == dest) {
            return step;
        }
        // at each point we can go either way
        int pos = steps(source + step + 1, step + 1, dest);  // if we go on positive side
        int neg = steps(source - step - 1, step + 1, dest);  // if we go on negative side
        return Math.min(pos, neg); // minimum of both cases
    }

    // Driver Code
    public static void main(String[] args) {
        int dest = 3;
        System.out.println("No. of steps required" + " to reach " + dest + " is " + steps(0, 0, dest));
    }
}
