package vmware;

// Given a non-empty array of integers, every element appears 3 times except for one which appears exactly once find that number.

// Time Complexity O(n)

public class SingleNumberII {

    private static int singleNumberII(int[] a) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : a) {
                if ((n >> i & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            result |= sum << i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumberII(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumberII(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
