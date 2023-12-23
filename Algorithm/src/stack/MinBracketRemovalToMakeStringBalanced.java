package stack;

public class MinBracketRemovalToMakeStringBalanced {

    public static String minRemoveToMakeValid(String s) {
        StringBuilder temp = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            temp.append(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            if (temp.charAt(i) == '(' && open > 0) {
                open--;
            } else {
                str.append(temp.charAt(i));
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }
}
