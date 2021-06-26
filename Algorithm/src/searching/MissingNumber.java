package searching;

public class MissingNumber {

    private static int[] arr = {9, 7, 3, 4, 5, 1, 2, 8, 6};

    public static int findMissing() {
        int min = arr[0];
        int max = arr[0];

        // find the inclusive range of the set of sequential numbers
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        int missing = 0;
        for (int i = 0; i < arr.length; i++) {
            missing ^= arr[i];
        }
        for (int i = min; i <= max; i++) {
            missing ^= i;
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println(findMissing());
    }
}
