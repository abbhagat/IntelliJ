package stack;

import static java.lang.Integer.max;

// Input: exp = "abh)ina)w(ku(mar(bhagat))" Output: abhinaw(ku(mar(bhagat)))
// Input: exp = "1+5)+5+)6+(5+9)*9"         Output: 1+5+5+6+(5+9)*9
// Input: exp = "lee(t(c)o)de)")"           Output: lee(t(c)o)de
// Input: exp = "ab(c)d"                    Output: ab(c)d

// Time Complexity - O(n)
public class BalanceStringAfterRemovingExtraBracket {

  private static StringBuilder balancedString(String exp) {
    StringBuilder sb = new StringBuilder();
    int open = 0;
    for (char c : exp.toCharArray()) {
      if (c == '(') {
        sb.append(c);
        open++;
      } else if (c == ')' && open > 0) {
        sb.append(c);
        open--;
      } else if (c != ')') {
        sb.append(c);
      }
    }
    return sb.append(")".repeat(max(0, open)));
  }

  public static void main(String[] args) {
    System.out.println(balancedString("abh)ina)w(ku(mar(bhagat))"));
    System.out.println(balancedString("1+5)+5+)6+(5+9)*9"));
    System.out.println(balancedString("lee(t(c)o)de)"));
    System.out.println(balancedString("ab(c)d"));
  }
}
