package leetcodes;

/**
 * Count Asterisks
 * You are given a string s, where every two consecutive vertical bars '|' are grouped into a pair.
 * In other words, the characters between the first and the second '|' are ignored, and the same goes for the rest of the '|' characters.
 * Return the number of '*' characters in s that are not in between any two '|' characters.
 * Input: s = "l|*e*et|c**o|*de|"
 * Output: 2
 * Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
 * The characters between the first and second '|' are excluded from the answer.
 * Also, the characters between the third and fourth '|' are excluded from the answer.
 * There are 2 asterisks considered. Therefore, we return 2.
 * Example 2:
 * Input: s = "iamprogrammer"
 * Output: 0
 * Explanation: In this example, there are no asterisks in s. Therefore, we return 0.
 * Example 3:
 * Input: s = "yo|uar|e**|b|e***au|tifu|l"
 * Output: 5
 * Explanation: The considered characters are underlined: "yo|uar|e**|b|e***au|tifu|l". There are 5 asterisks considered. Therefore, we return 5.
 */
public class CountAsterisks {

    private static int countAsterisks(String s) {
        boolean insidePipe = false;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                insidePipe = !insidePipe;
            }
            if (!insidePipe && c == '*') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(countAsterisks("iamprogrammer"));
        System.out.println(countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }
}
