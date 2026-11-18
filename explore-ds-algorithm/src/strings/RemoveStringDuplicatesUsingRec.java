package strings;

public class RemoveStringDuplicatesUsingRec {

  private static final int[] temp = new int[128];

  private static void removeDuplicates(char[] c, int i) {
    if (i < c.length) {
      temp[c[i]]++;
      removeDuplicates(c, ++i);
    }
  }

  public static void main(String[] args) {
    char[] a = "JavavavaJi".toCharArray();
    removeDuplicates(a, 0);
    for (char c : a) {
      if (temp[c] >= 1) {
        System.out.print(c);
        temp[c] = 0;
      }
    }
    System.out.println();
  }

}
