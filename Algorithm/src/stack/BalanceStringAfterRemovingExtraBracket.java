package stack;

// Input: exp = “abh)ina)w(ku(mar(bhagat))” Output: abhinaw(ku(mar(bhagat)))
// Input: exp = “1+5)+5+)6+(5+9)*9” Output: 1+5+5+6+(5+9)*9

// Time Complexity - O(n)
public class BalanceStringAfterRemovingExtraBracket {
    private static void balancedString(char[] exp) {
        int n = 0;
        for (char c : exp) {
            if (c == '(') {
                System.out.print(c);
                n++;
            } else if (c == ')' && n > 0) {
                System.out.print(c);
                n--;
            } else if (c != ')') {
                System.out.print(c);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        balancedString("abh)ina)w(ku(mar(bhagat))".toCharArray());
        System.out.println();
        balancedString("1+5)+5+)6+(5+9)*9".toCharArray());
    }
}
