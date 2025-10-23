package linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueWordsInBigON {

  private static char unique(String s) {
    Node first = null, temp = null;
    Map<Character, Node> map = new LinkedHashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        Node deleteNode = map.get(s.charAt(i));
        // deleteFromDoubleLinkedList
      } else {
        Node node = new Node(i, temp);
        map.put(s.charAt(i), node);
        if (first == null) {
          first = temp = node;
        } else {
          temp.next = node;
          temp = node;
        }
      }
    }
    return s.charAt(first.num);
  }

  public static void main(String[] args) {

  }
}
