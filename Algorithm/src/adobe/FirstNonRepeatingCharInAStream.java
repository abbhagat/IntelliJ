package adobe;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Stream;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class FirstNonRepeatingCharInAStream {

  private static void firstNoRepeatingChars(char[] a) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    for (char x : a) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
      if (entrySet.getValue() == 1) {
        System.out.print(entrySet.getKey() + "  ");
        break;
      }
    }
  }

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
    System.out.println();
  }

  public static void main(String[] args) {
    firstNonRepeatingChar(Stream.of('a', 'a', 'b', 'b', 'c', 'd'));
    firstNonRepeatingChar(Stream.of('a', 'b', 'b', 'c', 'c', 'e'));
    firstNoRepeatingChars(new char[]{'a', 'b', 'b', 'c', 'c', 'e'});
  }
}
