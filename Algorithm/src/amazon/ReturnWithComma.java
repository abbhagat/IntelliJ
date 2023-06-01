package amazon;

// Time  Complexity  O(n)

public class ReturnWithComma {

    public static String returnWithCommas(String num) {
        for (int i = num.length() - 1 , j = 1; i > 0; i--, j++) {
            if (j % 3 == 0) {
                num = num.substring(0, i) + "," + num.substring(i);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(returnWithCommas("1010503"));
        System.out.println(returnWithCommas("1010503123"));
    }
}
