package leetcode;


// Time Complexity: O(n) where n is length of input string.
// Auxiliary Space: O(n)
public class ZigZagConversion {

    private static String convert(String s, int rows) {
        StringBuilder[] sb = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < rows && i < s.length(); j++, i++) {
                sb[j].append(s.charAt(i));
            }
            for (int j = rows - 2; j > 0 && i < s.length(); j--, i++) {
                sb[j].append(s.charAt(i));
            }
        }
        for (i = 1; i < rows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("GEEKSFORGEEKS", 3));
    }
}
