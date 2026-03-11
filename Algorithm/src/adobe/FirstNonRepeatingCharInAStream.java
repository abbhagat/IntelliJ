package adobe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class FirstNonRepeatingCharInAStream {

  private static void firstNonRepeatingChar(Stream<Character> stream) {
    int[] temp = new int[128];
    Queue<Character> q = new LinkedList<>();
    stream.forEach(c -> {
      temp[c]++;
      q.add(c);
      while (!q.isEmpty() && temp[q.peek()] > 1) {
        q.poll();
      }
      System.out.println(q.isEmpty() ? -1 : String.valueOf(q.peek()));
    });
  }

  public static void main(String[] args) {
    firstNonRepeatingChar(Stream.of('a', 'a', 'b', 'b', 'c', 'd'));
  }
}
