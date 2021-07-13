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
        int len = exp.length;                                  // length of expression must be even to make it balanced by using reversals.
        if (len % 2 != 0) {
            return -1;
        }
        int open = 0, close = 0;
        for (int i = 0; i < len; i++) {
            if (exp[i] == '{') {                               // If current bracket is open then increment open count.
                open++;
            } else {                                         // If current bracket is close, check if it balances opening bracket
                int j = open == 0 ? close++ : open--;      // If yes then decrement count of unbalanced opening bracket
            }                                             // If no increment count of closing bracket.
        }
        int result = open / 2 + close / 2;
        close %= 2;    // For the case: "}{" or when one closing and one opening bracket remains for pairing, then both need to be reversed.
        result += close != 0 ? 2 : 0;
        return result;
    }

    public static void main(String args[]) {
        System.out.println(countMinReversals("}{{}}{{{".toCharArray()));
    }
}
