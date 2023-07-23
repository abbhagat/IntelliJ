package geeks;

public class ParseIntImplementation {

    public static int parseInt(String s) {
        int num = 0, j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - '0') * Math.pow(10, j++);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("235"));
    }
}
