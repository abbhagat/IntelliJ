package searching;

public class LinearSearch {

  private static boolean linearSearch(int[] a, int n) {
    for (int x : a) {
      if (x == n) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {20, 3, 15, 15, 15, 6, 9, 8, 2, 1};
    System.out.println(linearSearch(a, 15) ? "Present" : "Not Present");
    System.out.println(linearSearch(a, 21) ? "Present" : "Not Present");
  }
}
