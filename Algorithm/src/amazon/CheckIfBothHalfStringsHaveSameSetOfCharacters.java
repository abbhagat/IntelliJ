package amazon;

// Time  Complexity : O(n)
public class CheckIfBothHalfStringsHaveSameSetOfCharacters {

  private static boolean hasSameSetOfChars(char[] a) {
    int[] temp = new int[128];
    int i = 0, j = a.length - 1;
    while (i <= j) {
      temp[a[i++]]++;
      temp[a[j--]]--;
    }
    for (int x : temp) {
      if (x != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(hasSameSetOfChars("a".toCharArray()));
    System.out.println(hasSameSetOfChars("abccab".toCharArray()));
    System.out.println(hasSameSetOfChars("abbaab".toCharArray()));
    System.out.println(hasSameSetOfChars("abcdabc".toCharArray()));
  }
}
