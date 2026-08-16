package adobe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class FirstNonRepeatingCharInAStream {

  private static final int[] temp = new int[128];
  private static final Queue<Character> q = new LinkedList<>();

  private static void firstNonRepeatingChar(char c) {
    temp[c]++;
    q.add(c);
    while (!q.isEmpty() && temp[q.peek()] > 1) {
      q.poll();
    }
    System.out.println(q.isEmpty() ? -1 : String.valueOf(q.peek()));
  }

  public static void main(String[] args) {
    Stream.of('a', 'a', 'b', 'b', 'c', 'd').forEach(FirstNonRepeatingCharInAStream::firstNonRepeatingChar);
    System.out.println();
    Arrays.fill(temp, 0);
    q.clear();
    Stream.of('x', 'y', 'z', 'p', 'z', 'x').forEach(FirstNonRepeatingCharInAStream::firstNonRepeatingChar);
  }
}
