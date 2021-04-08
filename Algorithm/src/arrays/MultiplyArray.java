package arrays;

/*Given an array of n numbers, return an array ans such that ans[i]
 *contains the product of all elements in array except array[i].
 *Ex. array = {1, 7, 4, 3}, ans = {84, 12, 21, 28}.
 *
 */

public class MultiplyArray {

    private static int[] a = { 1, 2, 3, 4, 5 };

    public static void main(String[] args) {
        int mul = 1;
        for (int x : a) {
            mul *= x;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = mul / a[i];
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
    }
}
