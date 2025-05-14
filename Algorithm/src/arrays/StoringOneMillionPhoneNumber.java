package arrays;

public class StoringOneMillionPhoneNumber {

    private static final boolean[] flag = new boolean[1000000000];

    private static void add(int index) {
        flag[index] = true;
    }

    private static void remove(int index) {
        flag[index] = false;
    }

    private static boolean isPresent(int index) {
        return flag[index];
    }

    public static void main(String[] args) {
        int[] nums = {45, 23, 64, 3242, 454, 324, 324, 354, 12};
        for (int x : nums) {
            add(x);
        }
        System.out.println(isPresent(23));
        remove(23);
        System.out.println(isPresent(11));
    }
}
