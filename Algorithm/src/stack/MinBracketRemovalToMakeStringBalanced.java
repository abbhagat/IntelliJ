package stack;

public class MinBracketRemovalToMakeStringBalanced {

    public static String minRemoveToMakeValid(String str) {
        StringBuilder s = new StringBuilder();
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
            s.append(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(' && open > 0) {
                open--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("abh)ina)w(ku(mar(bhagat))"));
    }
}
