package amazon;

public class ReturnWithComma {

    public static String returnWithCommas(String num) {
        int digits = 0;
        for (int i = num.length() - 1; i > 0; i--) {
            digits++;
            if (digits % 3 == 0) {
                num = num.substring(0, i) + "," + num.charAt(i) + num.substring(i + 1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(returnWithCommas("1010503"));
    }
}
