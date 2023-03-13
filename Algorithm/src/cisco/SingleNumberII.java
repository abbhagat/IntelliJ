package cisco;

// Given a non-empty array of integers, every element appears 3 times except for one which appears exactly once.
// Find that number
public class SingleNumberII {

    private static int singleNumberII(int[] a) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : a)
                if ((n >> i & 1) == 1) {
                    sum++;
                }
            sum %= 3;
            res |= sum << i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumberII(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumberII(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
