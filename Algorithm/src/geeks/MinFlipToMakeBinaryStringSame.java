package geeks;

/**
 * Input: A = “10010010”, B = “00001000”
 * nOutput: 3
 * Explanation:
 * Operation 1: Flipping A[0] modifies A to “00010010”.
 * Operation 2: Flipping A[6] modifies A to “00010000”.
 * Operation 3: Swapping A[3] and A[4] modifies A to “00001000”
 * Therefore, the total number of operations is 3.
 * Input: A = “11”, B = “00”
 * Output: 2
 */
public class MinFlipToMakeBinaryStringSame {

    private static int minimumOperation(char[] a, char[] b) {
        int i = 0, minFlips = 0;
        while (i < a.length) {
            if (a[i] == b[i]) {
                i++;
            } else if ((i + 1 < a.length) && a[i] == b[i + 1] && a[i + 1] == b[i]) {
                minFlips++;
                i = i + 2;
            } else if (a[i] != b[i]) {
                minFlips++;
                i++;
            } else {
                i++;
            }
        }
        return minFlips;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperation("10010010".toCharArray(), "00001000".toCharArray()));
        System.out.println(minimumOperation("11".toCharArray(), "00".toCharArray()));
    }
}
