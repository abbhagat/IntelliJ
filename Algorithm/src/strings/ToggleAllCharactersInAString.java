package strings;

public class ToggleAllCharactersInAString {

  private static char[] toggleCase(char[] c) {
    for (int i = 0; i < c.length; i++) {
      if (Character.isAlphabetic(c[i])) {
        c[i] += c[i] >= 65 && c[i] <= 90 ? 32 : -32;
      }
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(toggleCase("aBc12#".toCharArray()));
  }
}
