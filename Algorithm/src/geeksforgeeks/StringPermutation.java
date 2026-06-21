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
    for (char c : p) {  // small string length first
      sData[c]++;
      pData[c]++;
    }
    if (matches(sData, pData)) {
      return true;
    }
    int j = 0;
    for (int i = p.length; i < s.length; i++) {  // traverse the larger string "s" from index = p to s.length
      sData[s[i]]++;
      sData[s[j]]--;
      if (matches(sData, pData)) {
        return true;
      }
      j++;
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
