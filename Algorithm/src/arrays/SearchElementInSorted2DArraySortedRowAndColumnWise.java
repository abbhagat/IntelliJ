package goldmansach;

/*
 * Start with top right element
   Loop:
     Compare this element e with x
     i) if they are equal then return its position
    ii) e < x then move it to down
   iii) e > x then move it to left
   		Repeat above 3 steps till you find element
		If not found return false
 *
 */

public class SearchElementInSorted2DArraySortedRowAndColumnWise {

    static boolean search(int[][] a, int key) {
        int R1 = 0;
        int C1 = 0;
        int R2 = a[0].length - 1;
        int C2 = a[0].length - 1;
        while (R1 <= R2 && C1 <= C2) {
            if (key < a[R1][C2]) {
                C2--;
            } else if (key > a[R1][C2]) {
                R1++;
            } else {
                System.out.println("[" + R1 + "]" + "[" + C2 + "]");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(search(a, 5) ? "Present" : "Not Present");
    }
}
