package strings;

public class StringHasAllUniqueCharacters {

  private static boolean hasAllUniqueChar(String s) {
    int[] temp = new int[128];
    for (char c : s.toCharArray()) {
      temp[c]++;
    }
    for (int x : temp) {
      if (x > 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(hasAllUniqueChar("ABCDE") ? "Unique" : "Not Unique");
    System.out.println(hasAllUniqueChar("ABCDA") ? "Unique" : "Not Unique");
    System.out.println(hasAllUniqueChar("aBCdE") ? "Unique" : "Not Unique");
  }
}
