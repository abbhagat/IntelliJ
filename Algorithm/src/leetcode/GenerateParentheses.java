package leetcode;

// Time Complexity O(2^n)  For every index there can be two options ‘{‘ or ‘}’
// Space Complexity: O(n)

public class GenerateParentheses {

    private static void generateParentheses(String bracket, int open, int close, int n) {
        if (bracket.length() == 2 * n) {
            System.out.println(bracket);
        }
        if (open < n) {
            generateParentheses(bracket + "(", open + 1, close, n);
        }
        if (close < open) {
            generateParentheses(bracket + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        generateParentheses("", 0, 0, 1);
        System.out.println();
        generateParentheses("", 0, 0, 2);
        System.out.println();
        generateParentheses("", 0, 0, 3);
    }
}
