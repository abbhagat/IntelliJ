package geeksforgeeks;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class StringPermutation {

  public static boolean checkInclusion(char[] c1, char[] c2) {
    if (c1.length > c2.length) {
      return false;
    }
    int[] temp1 = new int[128];
    int[] temp2 = new int[128];
    for (char c : c1) {
      temp1[c]++;
      temp2[c]++;
    }
    if (matches(temp1, temp2)) {
      return true;
    }
    for (int i = 0, j = c1.length; j < c2.length; i++, j++) {
      temp2[c2[j]]++;
      temp2[c2[i]]--;
      if (matches(temp1, temp2)) {
        return true;
      }
    }
    return matches(temp1, temp2);
  }

  public static boolean matches(int[] temp1, int[] temp2) {
    for (int i = 0; i < 128; i++) {
      if (temp1[i] != temp2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("cat".toCharArray(), "retract".toCharArray()));
    System.out.println(checkInclusion("cat".toCharArray(), "tacretw".toCharArray()));
  }
}
