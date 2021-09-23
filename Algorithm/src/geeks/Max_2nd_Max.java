package geeks;

public class Max_2nd_Max {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int max, _2ndMax;
        max = _2ndMax = Integer.MIN_VALUE;
        for (int x : a) {
            if (x > max) {
                _2ndMax = max;
                max = x;
            } else if (x > _2ndMax) {
                _2ndMax = x;
            }
        }
        System.out.println("Max : " + max + "  _2ndMax : " + _2ndMax);
    }
}
