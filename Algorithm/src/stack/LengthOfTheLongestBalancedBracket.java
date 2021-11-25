package stack;

import java.util.Stack;

import static java.lang.Integer.max;

public class LengthOfTheLongestBalancedBracket {

    private static int findLength(String bracket) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < bracket.length(); i++) {
            if(bracket.charAt(i) == '{'){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                maxLength = max(maxLength, i - stack.peek());
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength("{}}"));
    }
}
