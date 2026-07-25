package stack;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class BalancedBracketMinSwaps {

  public static int minSwaps(String s) {
    int open = 0, swaps = 0;
    for (char c : s.toCharArray()) {
      open += c == '(' ? 1 : -1;
      if (open < 0) {  // More ')' than '(' encountered
        swaps++;
        open = 1;
      }
    }
    return swaps;
  }

  public static void main(String[] args) {
    System.out.println(minSwaps("))(("));       // 1
    System.out.println(minSwaps("()"));         // 0
    System.out.println(minSwaps("(()())"));     // 0
    System.out.println(minSwaps(")))(("));      // 2
    System.out.println(minSwaps("()))(("));     // 1
  }
}
