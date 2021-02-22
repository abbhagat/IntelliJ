package arrays;

public class _2ndMinElement {

    public static void main(String[] args) {

        int[] a = {-1, -3, -5, -4, -2};
        int min, _2ndMin;
        min = _2ndMin = a[0];
        for (int x : a) {
            min = min > x ? x : min;
            _2ndMin = _2ndMin < x ? x : _2ndMin;
        }
        for (int x : a) {
            if (x > min && x <= _2ndMin) {
                _2ndMin = x;
            }
        }
        System.out.println("Min :- " + min + "\t _2ndMin :- " + _2ndMin);
    }
}
