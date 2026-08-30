package adobe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class FirstRepeatingCharInAStream {

  private static void firstRepeatingChar(Stream<Character> stream) {
    int[] temp = new int[128];
    Queue<Character> q = new LinkedList<>();
    stream.forEach(c -> {
      temp[c]++;
      q.add(c);
      while (!q.isEmpty() && temp[q.peek()] == 1) {
        q.poll();
      }
      System.out.println(q.isEmpty() ? -1 : String.valueOf(q.peek()));
    });
  }

  public static void main(String[] args) {
    firstRepeatingChar(Stream.of('a', 'b', 'c', 'b', 'a', 'd'));
    System.out.println();
    firstRepeatingChar(Stream.of('a', 'b', 'b', 'c', 'c', 'e'));
  }
}
