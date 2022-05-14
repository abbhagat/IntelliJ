package cisco;

public class NumOfDecodeWays {

    private static int decodeWays(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int l = s.length();
        int[] ways = new int[l + 1];
        ways[0] = 1;
        ways[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= l; i++) {
            int _1Digit = Integer.valueOf(s.substring(i - 1, i));
            int _2Digit = Integer.valueOf(s.substring(i - 2, i));
            ways[i] = (_1Digit != 0 ? ways[i - 1] : 0) + (10 <= _2Digit && _2Digit <= 26 ? ways[i - 2] : 0);
        }
        return ways[l];
    }

    public static void main(String[] args) {
        System.out.println(decodeWays("12"));
        System.out.println(decodeWays("226"));
    }
}
