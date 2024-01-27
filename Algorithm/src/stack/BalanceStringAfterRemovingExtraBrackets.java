package stack;

public class BalanceStringAfterRemovingExtraBrackets {

    public static String minRemoveToMakeValid(String str) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && open > 0) {
                open--;
            } else {
                result.append(c);
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("abh)ina)w(ku(mar(bhagat))"));
    }
}
