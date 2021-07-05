package geeks;

/*
Method 1: Recursion.
In this post, we will discuss a solution to a general problem with ‘n’ eggs and ‘k’ floors.
The solution is to try dropping an egg from every floor(from 1 to k) and recursively
calculate the minimum number of droppings needed in the worst case.
The floor which gives the minimum value in the worst case is going to be part of the solution.
In the following solutions, we return the minimum number of trials in the worst case;
these solutions can be easily modified to print floor numbers of every trial also.
Meaning of a worst-case scenario: Worst case scenario gives the user the surety of the threshold floor.
For example- If we have ‘1’ egg and ‘k’ floors, we will start dropping the egg from the first floor till
the egg breaks suppose on the ‘kth’ floor so the number of tries to give us surety is ‘k’.
1) Optimal Substructure:
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.


If the egg breaks after dropping from ‘xth’ floor, then we only need to check for floors lower than ‘x’
with remaining eggs as some floor should exist lower than ‘x’ in which egg would not break;
so the problem reduces to x-1 floors and n-1 eggs.
If the egg doesn’t break after dropping from the ‘xth’ floor,
then we only need to check for floors higher than ‘x’;
so the problem reduces to ‘k-x’ floors and n eggs.
Since we need to minimize the number of trials in worst case,
we take the maximum of two cases. We consider the max of above two
cases for every floor and choose the floor which yields minimum number of trials.


k ==> Number of floors
n ==> Number of Eggs
eggDrop(n, k) ==> Minimum number of trials needed to find the critical
floor in worst case.
eggDrop(n, k) = 1 + min{max(eggDrop(n – 1, x – 1), eggDrop(n, k – x)), where x is in {1, 2, …, k}}
Concept of worst case:
For example :
Let there be ‘2’ eggs and ‘2’ floors then-:
If we try throwing from ‘1st’ floor:
Number of tries in worst case= 1+max(0, 1)
0=>If the egg breaks from first floor then it is threshold floor (best case possibility).
1=>If the egg does not break from first floor we will now have ‘2’ eggs and 1 floor to test which will give answer as
‘1’.(worst case possibility)
We take the worst case possibility in account, so 1+max(0, 1)=2
If we try throwing from ‘2nd’ floor:
Number of tries in worst case= 1+max(1, 0)
1=>If the egg breaks from second floor then we will have 1 egg and 1 floor to find threshold floor.(Worst Case)
0=>If egg does not break from second floor then it is threshold floor.(Best Case)
We take worst case possibility for surety, so 1+max(1, 0)=2.
The final answer is min(1st, 2nd, 3rd….., kth floor)
So answer here is ‘2’.
 */
public class EggDroppingPuzzle {

    private static int eggDrop(int eggs, int floor) {
        if (floor == 1 || floor == 0) {  // If there are no floors, then no trials needed or if there is one floor only one trial needed
            return floor;
        }
        if (eggs == 1) { // We need k trials for one egg and k floors
            return floor;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floor; i++) {  // Consider all droppings from 1st floor to kth floor and return the minimum of these values plus 1
            int result = Math.max(eggDrop(eggs - 1, i - 1), eggDrop(eggs, floor - i));
            min = result < min ? result : min;
        }
        return min + 1;
    }

    public static void main(String args[]) {
        int egg = 2, floor = 10;
        System.out.print("Minimum number of trials in worst case with " + egg + " eggs and " + floor + " floors is " + eggDrop(egg, floor));
    }
}
