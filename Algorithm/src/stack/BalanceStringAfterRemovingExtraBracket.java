package stack;

/*
Input: exp = “abh)ina)w(ku(mar(bhagat))”
Output: abhinaw(ku(mar(bhagat)))
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
        for (char c : exp) {
            if (c == '(') {
                System.out.print(c);               // print c and increment count by 1
                count++;
            } else if (c == ')' && count > 0) {  // check if closing bracket and count != 0
                System.out.print(c);
                count--;
            } else if (c != ')') {               // if c not a closing brackets print it
                System.out.print(c);
            }
        }
        for (int i = 1; i <= count; i++) {
            System.out.print(")");              // print remaining closing brackets
        }
    }

    public static void main(String[] args) {
        balancedString("abh)ina)w(ku(mar(bhagat))".toCharArray());
        System.out.println();
        balancedString("1+5)+5+)6+(5+9)*9".toCharArray());
    }
}
