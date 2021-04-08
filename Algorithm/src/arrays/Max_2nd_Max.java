package arrays;

public class Max_2nd_Max {

    public static void main(String[] args) {
        int[] a = {-3, -6};
        int max, min;
        max = min = a[0];
        for (int x : a) {
            max = max < x ? x : max;
            min = min > x ? x : min;
        }
        int _2ndMax = min;
        for (int x : a) {
            if (x < max && x >= _2ndMax) {
                _2ndMax = x;
            }
        }
        System.out.println("Max : " + max + "  _2ndMax : " + _2ndMax);
        System.out.println(null != null);
        System.out.println(null == null);
    }
}
