package geeks;

/**
 Input: A = “10010010” B = “00001000” Output: 3
 Explanation:
 Operation 1: Flipping A[0] modifies A to “00010010”
 Operation 2: Flipping A[6] modifies A to “00010000”
 Operation 3: Swapping A[3] and A[4] modifies A to “00001000”
 Therefore, the total number of operations is 3.
 Input: A = “11” B = “00” Output: 2
 */
public class MinFlipToMakeBinaryStringSame {

    private static int minFlips(char[] a, char[] b) {
        int minFlips = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                minFlips++;
            }
            if (i + 1 < a.length && i + 1 < b.length && a[i] == b[i + 1] && a[i + 1] == b[i]) {
                i++;
            }
        }
        return minFlips;
    }

    public static void main(String[] args) {
        System.out.println(minFlips("10010010".toCharArray(), "00001000".toCharArray()));
        System.out.println(minFlips("11".toCharArray(), "00".toCharArray()));
        System.out.println(minFlips("xx".toCharArray(), "yy".toCharArray()));
        System.out.println(minFlips("xy".toCharArray(), "yx".toCharArray()));
        System.out.println(minFlips("xx".toCharArray(), "xy".toCharArray()));
        System.out.println(minFlips("xxyyxyxyxx".toCharArray(), "xyyxyxxxyx".toCharArray()));
    }
}
