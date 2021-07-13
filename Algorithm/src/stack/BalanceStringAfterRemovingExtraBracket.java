package stack;

/*
Input: exp = “gau)ra)v(ku(mar(rajput))”
Output: gaurav(ku(mar(rajput)))
Input: exp = “1+5)+5+)6+(5+9)*9”
Output: 1+5+5+6+(5+9)*9

Start traversing from left to right.
Check if the element at current index is an opening bracket ‘(‘ then print that bracket and increment count.
Check if the element at current index is a closing bracket ‘)’ and if the count is not equal to zero then print it and decrement the count.
Check if there is any element other than brackets at the current index in the string then print it.
And in last if the count is not equal to zero then print ‘)’ equal to the number of the count to balance the string
 */

public class BalanceStringAfterRemovingExtraBracket {
    public static void balancedString(char[] exp) {
        int count = 0;
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '(') {
                System.out.print(exp[i]);               // print exp[i] and increment count by 1
                count++;
            } else if (exp[i] == ')' && count != 0) {  // check if closing bracket and count != 0
                System.out.print(exp[i]);
                count--;
            } else if (exp[i] != ')') {               // if exp[i] not a closing brackets print it
                System.out.print(exp[i]);
            }
        }
        if (count != 0) {                             // balance the brackets if opening brackets are more then closing brackets
            for (int i = 0; i < count; i++) {
                System.out.print(")");              // print remaining closing brackets
            }
        }
    }

    public static void main(String args[]) {
        balancedString("gau)ra)v(ku(mar(rajput))".toCharArray());
    }
}
