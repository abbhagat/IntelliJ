package geeks;

public class Min_2nd_Min {

    public static void main(String[] args) {
        int[] a = {4, -1, 8, -2, -7};
        int min, _2ndMin;
        min = _2ndMin = Integer.MAX_VALUE;
        for (int x : a) {
            if (x < min) {
                _2ndMin = min;
                    min = x;
            } else if (x < _2ndMin) {
                _2ndMin = x;
            }
        }

        System.out.println("Min : " + min + "\t _2ndMin : " + _2ndMin);
    }
}
