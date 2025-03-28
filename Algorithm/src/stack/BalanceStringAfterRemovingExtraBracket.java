package stack;

// Input: exp = "abh)ina)w(ku(mar(bhagat))" Output: abhinaw(ku(mar(bhagat)))
// Input: exp = "1+5)+5+)6+(5+9)*9" Output: 1+5+5+6+(5+9)*9

// Time Complexity - O(n)
public class BalanceStringAfterRemovingExtraBracket {

    private static void balancedString(String exp) {
        int open = 0;
        for (char c : exp.toCharArray()) {
            if (c == '(') {
                System.out.print(c);
                open++;
            } else if (c == ')' && open > 0) {
                System.out.print(c);
                open--;
            } else if (c != ')') {
                System.out.print(c);
            }
        }
        for (int i = 1; i <= open; i++) {
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        balancedString("abh)ina)w(ku(mar(bhagat))");
        System.out.println();
        balancedString("1+5)+5+)6+(5+9)*9");
    }
}
