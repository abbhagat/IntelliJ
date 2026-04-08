package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HuffmanCoding {

  private static final StringBuilder result = new StringBuilder();
  private static final Map<StringBuilder, Character> map = new HashMap<>();

  public static void encode(Node root, String str) {
    for (char c : str.toCharArray()) {
      findPath(root, c, new LinkedList<>(), ' ');
    }
    System.out.println(result);
  }

  public static void findPath(Node root, char c, LinkedList<Character> list, char x) {
    if (root == null) {
      return;
    }
    list.add(x);
    if (root.num == c) {
      list.removeFirst();
      list.forEach(chars -> {
        StringBuilder sb = new StringBuilder(result.append(chars));
        map.put(sb, c);
      });
      list.removeLast();
      return;
    }
    findPath(root.left, c, list, '0');
    findPath(root.right, c, list, '1');
    list.removeLast();
  }

  public static void decode(StringBuilder sb) {
    StringBuilder result = new StringBuilder("");
    for (char c : sb.toString().toCharArray()) {
      sb.append(c);
      if (map.containsKey(sb)) {
        System.out.println(map.get(sb));
        sb = new StringBuilder();
      }
    }
  }

  public static void main(String[] args) {
    encode(null, "AAAAAABCCCCCCDDEEEEE");
    decode(new StringBuilder("1010101010100001111111111110010010101010101"));
  }
}
