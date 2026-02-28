package geeksforgeeks;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class StringPermutation {

  public static boolean checkInclusion(char[] s, char[] p) {
    if (s.length < p.length) {
      return false;
    }
    int[] sData = new int[128];
    int[] pData = new int[128];
    for (char c : p) {
      sData[c]++;
      pData[c]++;
    }
    if (matches(sData, pData)) {
      return true;
    }
    for (int i = 0, j = p.length; j < s.length; i++, j++) {
      sData[s[j]]++;
      sData[s[i]]--;
      if (matches(sData, pData)) {
        return true;
      }
    }
    return matches(sData, pData);
  }

  public static boolean matches(int[] sData, int[] pData) {
    for (int i = 0; i < 128; i++) {
      if (sData[i] != pData[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("retract".toCharArray(), "cat".toCharArray()));
    System.out.println(checkInclusion("tacretw".toCharArray(), "cat".toCharArray()));
  }
}
