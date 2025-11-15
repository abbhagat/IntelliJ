package geeks;

public class ParseIntImplementation {

    public static int parseInt(String s) {
        int n = 0, k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            n += (int) ((s.charAt(i) - '0') * Math.pow(10, k++));
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("235"));
    }
}
