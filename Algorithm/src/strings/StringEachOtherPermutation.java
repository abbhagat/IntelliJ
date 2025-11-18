package strings;

public class StringEachOtherPermutation {

  private static boolean isPermutation(char[] c1, char[] c2) {
    if (c1.length == c2.length) {
      int[] temp = new int[128];
      for (int i = 0; i < c1.length; i++) {
        temp[c1[i]]++;
        temp[c2[i]]--;
      }
      for (int x : temp) {
        if (x != 0) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isPermutation("ABC".toCharArray(), "CAB".toCharArray()) ? "Permutation" : "Not Permutation");
  }
}
