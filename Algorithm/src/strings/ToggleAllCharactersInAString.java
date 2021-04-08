package strings;

public class ToggleAllCharactersInAString {
    public static void main(String[] args) {
        char[] a = "aBc12#".toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 65 && a[i] <= 90) {
                a[i] += 32;
            } else if (a[i] >= 97 && a[i] <= 122) {
                a[i] -= 32;
            }
        }
        System.out.println(a);
    }
}
