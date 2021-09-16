package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static void generateParentheses(String bracket, int open, int close, int n, List<String> list) {
        if (bracket.length() == 2 * n) {
            list.add(bracket);
            System.out.println(bracket);
        }
        if (open < n) {
            generateParentheses(bracket + "(", open + 1, close, n, list);
        }
        if (close < open) {
            generateParentheses(bracket + ")", open, close + 1, n, list);
        }
    }

    public static void main(String[] args) {
        generateParentheses("", 0, 0, 3, new ArrayList<>());
    }
}
