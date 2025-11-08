package geeks;

public class Min_2nd_Min {

    private static void findMin2ndMin(int[] a) {
        int min = Integer.MAX_VALUE, _2ndMin = Integer.MAX_VALUE;
        for (int x : a) {
            if (x < min) {
                _2ndMin = min;
                min = x;
            } else if (x < _2ndMin) {
                _2ndMin = x;
            }
        }
        System.out.println("Min : " + min + "  2ndMin : " + _2ndMin);
    }

    public static void main(String[] args) {
        findMin2ndMin(new int[]{1, 2});
        findMin2ndMin(new int[]{3, 4, 5});
        findMin2ndMin(new int[]{1, 2, 3, 4, 5});
        findMin2ndMin(new int[]{4, -1, 8, -2, -7});
    }
}
