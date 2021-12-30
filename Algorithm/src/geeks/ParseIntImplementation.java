package geeks;

public class ParseIntImplementation {

    public static int parseInt(String s) {
        int num = 0;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            num += (s.charAt(i) - '0') * Math.pow(10, j);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(parseInt("235"));
    }
}
