package adobe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class FirstRepeatingCharInAStream {

  private static void firstRepeatingChar(Stream<Character> stream) {
    int[] temp = new int[128];
    Queue<Character> q = new LinkedList<>();
    stream.forEach(c -> {
      temp[c]++;
      q.add(c);
      while (!q.isEmpty() && temp[q.peek()] < 2) {
        q.poll();
      }
      System.out.println(q.isEmpty() ? -1 : String.valueOf(q.peek()));
    });
  }

  public static void main(String[] args) {
    firstRepeatingChar(Stream.of('a', 'b', 'c', 'b', 'a', 'd'));
    firstRepeatingChar(Stream.of('a', 'b', 'b', 'c', 'c', 'e'));
  }
}
