package paypal;

import static util.Swap.swap;

/*
Given a string x, return the “reversed” string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
Sample 1:
Input: s = “ab-cd”
Output: “dc-ba”
Sample 2:
Input: s = “a-bC-dEf-ghIj”
Output: “j-Ih-gfE-dCba”
 */
public class ReverseStringWithCondition {

    private static char[] reverse(char[] c) {
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (c[i] == '-') {
                i++;
            }
            if (c[j] == '-') {
                j--;
            }
            swap(c, i, j);
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(reverse("ab-cd".toCharArray()));
        System.out.println(reverse("a-bC-dEf-ghIj".toCharArray()));
    }
}
