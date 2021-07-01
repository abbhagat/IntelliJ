package geeks;

public class ParseIntImplementation {

    public static int parseInt(String s) {
        int sum = 0, i, n = 1;
        for (i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                sum += (c - 48) * n;
                n *= 10;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("235"));
    }
}
