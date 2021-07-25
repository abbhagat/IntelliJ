package stack;

/*
Input : exp = "}{"
Output : 2
We need to change '}' to '{' and '{' to
'}' so that the expression becomes balanced,
the balanced expression is '{}'

Input : exp = "}{{}}{{{"
Output : 3
The balanced expression is "{{{}}{}}"
 */

public class MinBracketRemovalToMakeBracketBalanced {

    private static int countMinReversals(char[] exp) {
        if (exp.length % 2 != 0) {  // length of expression must be even to make it balanced by using reversals.
            return -1;
        }
        int open = 0, close = 0;
        for (char c : exp) {
            if (c == '{') {                               // If current bracket is open then increment open count.
                open++;
            } else {                                         // If current bracket is close, check if it balances opening bracket
                int j = open == 0 ? close++ : open--;      // If yes then decrement count of unbalanced opening bracket
            }                                             // If no increment count of closing bracket.
        }
        return (int)(Math.ceil((0.0 + open) / 2) + Math.ceil((0.0 + close) / 2));
    }

    public static void main(String args[]) {
        System.out.println(countMinReversals("}{".toCharArray()));
    }
}
