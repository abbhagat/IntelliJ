package amazon;

// Time  Complexity : O(n)
public class ReturnWithComma {

    public static String returnWithCommas(String s, final int k) {
        for (int i = s.length() - 1, j = 1; i > 0; i--, j++) {
            if (j % k == 0) {
                s = s.substring(0, i) + "," + s.substring(i);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(returnWithCommas("1010503", 3));
        System.out.println(returnWithCommas("1010503123", 3));
    }
}
