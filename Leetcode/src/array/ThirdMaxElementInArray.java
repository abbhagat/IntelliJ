package array;

// Time  Complexity O(n)
// Space Complexity O(1)
public class ThirdMaxElementInArray {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 5, 6, 7, 2, 10};
        int max, _2ndMax, _3rdMax;
        max = _2ndMax = _3rdMax = Integer.MIN_VALUE;
        for (int x : a) {
            if (max < x) {
                _2ndMax = max;
                max = x;
            } else if (_2ndMax < x) {
                _2ndMax = x;
            }
        }
        for(int x : a){
            if(_3rdMax < x && x != max && x != _2ndMax){
                _3rdMax = x;
            }
        }
        System.out.println(_3rdMax);
    }
}
