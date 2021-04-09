package arrays;

/*
 * Find a point in an array where sum of left side array members(wrt to that point)
 * and right side(wrt to that point) are equal..in other words equilibrium point
 * int a[] ={1,3,4,10,18,3,1,6,3,1,4}; // 18 is the point..
 */

public class EquilibriumPointInAnArray {

    public static void main(String[] args) {
        int a[] = {1, 3, 4, 2, 15, 6, 3, 1};
        int sum1 = 0, sum2 = 0;
        for (int x : a) {
            sum1 += x;
        }
        for (int x : a) {
            sum2 += x;
            if (sum1 == sum2) {
                System.out.println(x);
                break;
            }
            sum1 -= x;
        }
    }

}
