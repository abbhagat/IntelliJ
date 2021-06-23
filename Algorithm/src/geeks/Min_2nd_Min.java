package geeks;

public class Min_2nd_Min {

    public static void main(String[] args) {
        int[] a = {4, -1, 8, -2, -7};
        int max, min;
        max = min = a[0];
        for (int x : a) {
            max = max < x ? x : max;
            min = min > x ? x : min;
        }
        int _2ndMin = max;
        for (int x : a) {
            if (x > min && x <= _2ndMin) {
                _2ndMin = x;
            }
        }
        System.out.println("Min : " + min + "\t _2ndMin : " + _2ndMin);
    }
}
