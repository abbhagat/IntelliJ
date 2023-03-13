package cisco;

public class SingleNumber {

    private static int singleNumber(int[] a) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : a)
                if ((n >> i & 1) == 1) {
                    sum++;
                }
            sum %= 2;
            res |= sum << i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
