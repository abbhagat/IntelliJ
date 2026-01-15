package geeks;

public class Max_2nd_Max {

  private static void findMax2ndMax(int[] a) {
    int max = Integer.MIN_VALUE, _2ndMax = Integer.MIN_VALUE;
    for (int x : a) {
      if (max < x) {
        _2ndMax = max;
            max = x;
      } else if (_2ndMax < x) {
        _2ndMax = x;
      }
    }
    System.out.println("Max : " + max + "  2ndMax : " + _2ndMax);
  }

  public static void main(String[] args) {
    findMax2ndMax(new int[]{1, 2});
    findMax2ndMax(new int[]{3, 4, 5});
    findMax2ndMax(new int[]{1, 2, 3, 4, 5});
  }
}
