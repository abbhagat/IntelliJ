package arrays;

public class _2ndMaxElement {

    public static void main(String[] args) {
        int[] a = {-1, -3, -5, -4, -2};
        int max, _2ndMax;
        max = _2ndMax = a[0];
        for (int x : a) {
            max = max < x ? x : max;
            _2ndMax = _2ndMax > x ? x : _2ndMax;
        }
        for (int x : a) {
            if (x < max && x >= _2ndMax) {
                _2ndMax = x;
            }
        }
        System.out.println("Max :- " + max + "\t _2ndMax :- " + _2ndMax);
    }
}
