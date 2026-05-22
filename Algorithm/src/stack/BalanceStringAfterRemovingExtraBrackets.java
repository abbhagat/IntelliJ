package stack;

// Time Complexity - O(n)
public class BalanceStringAfterRemovingExtraBrackets {

  public static StringBuilder minRemoveToMakeValid(String str) {
    StringBuilder sb = new StringBuilder();
    int open = 0;
    for (char c : str.toCharArray()) {
      if (c == '(') {
        open++;
      }
      if (c == ')' && open == 0) {
        continue;
      }
      if (c == ')') {
        open--;
      }
      sb.append(c);
    }
    str = sb.reverse().toString();
    sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (c == '(' && open > 0) {
        open--;
        continue;
      }
      sb.append(c);
    }
    return sb.reverse();
  }

  public static void main(String[] args) {
    System.out.println(minRemoveToMakeValid("abh)ina)w(ku(mar(bhagat))"));
    System.out.println(minRemoveToMakeValid("1+5)+5+)6+(5+9)*9"));
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("ab(c)d"));
    System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    System.out.println(minRemoveToMakeValid("))(("));
    System.out.println(minRemoveToMakeValid("a)b(c)d"));
  }
}
