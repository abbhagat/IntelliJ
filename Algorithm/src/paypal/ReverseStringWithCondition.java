package paypal;

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

    private static char[] reverse(char[] a) {
        for (int i = 0, j = a.length - 1; i <= j; i++, j--) {
            if (a[i] == '-') {
                i++;
            }
            if (a[j] == '-') {
                j--;
            }
            a[i] = (char) (a[i] ^ a[j]);
            a[j] = (char) (a[i] ^ a[j]);
            a[i] = (char) (a[i] ^ a[j]);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(reverse("ab-cd".toCharArray()));
        System.out.println(reverse("a-bC-dEf-ghIj".toCharArray()));
    }
}
