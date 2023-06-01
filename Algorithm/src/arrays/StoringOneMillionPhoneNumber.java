package arrays;

public class StoringOneMillionPhoneNumber {

    private static boolean[] flag = new boolean[1000000000];

    private static void add(int idx) {
        flag[idx] = true;
    }

    private static void remove(int idx) {
        flag[idx] = false;
    }

    private static boolean isPresent(int idx) {
        return flag[idx];
    }

    public static void main(String[] args) {
        int[] nums = {45, 23, 64, 3242, 454, 324, 324, 354, 12};
        for (int x : nums) {
            add(x);
        }
        System.out.println(isPresent(23));
    }
}
