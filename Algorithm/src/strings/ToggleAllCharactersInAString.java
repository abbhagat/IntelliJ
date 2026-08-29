package strings;

import static java.lang.Character.isAlphabetic;
import static java.lang.Character.toUpperCase;

public class ToggleAllCharactersInAString {

  private static char[] toggleCase(char[] c) {
    for (int i = 0; i < c.length; i++) {
      c[i] = isAlphabetic(c[i]) ? toUpperCase(c[i]) : c[i];
    }
    return c;
  }

  public static void main(String[] args) {
    System.out.println(toggleCase("aBc12#".toCharArray()));
  }
}
