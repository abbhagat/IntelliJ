package strings;

public class ToggleAllCharactersInAString {

    private static char[] toggleCase(char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 65 && c[i] <= 90) {
                c[i] += 32;
            } else if (c[i] >= 97 && c[i] <= 122) {
                c[i] -= 32;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(toggleCase("aBc12#".toCharArray()));
    }
}
