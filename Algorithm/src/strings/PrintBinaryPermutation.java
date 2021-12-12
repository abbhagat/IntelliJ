package strings;

// Time complexity – O(2^n)
//Space complexity – O(n)
public class PrintBinaryPermutation {

    private static void binaryPermutation(String s, int itr) {
        if (itr == 0) {
            System.out.println(s);
        } else {
            binaryPermutation(s + "0", itr - 1);
            binaryPermutation(s + "1", itr - 1);
        }
    }

    public static void main(String[] args) {
        binaryPermutation("", 3);
    }
}
