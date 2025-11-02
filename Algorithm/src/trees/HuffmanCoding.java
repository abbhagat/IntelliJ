package trees;

import java.util.LinkedList;

public class HuffmanCoding {

  private static final StringBuilder result = new StringBuilder();

  public static void encode(Node root, String str) {
    for (char c : str.toCharArray()) {
      findPath(root, c, new LinkedList<>(), ' ');
    }
    System.out.println(result);
  }

  public static void decode() {

  }

  public static void findPath(Node root, char c, LinkedList<Character> list, char x) {
    if (root == null) {
      return;
    }
    list.add(x);
    if (root.num == c) {
      list.removeFirst();
      list.forEach(result::append);
      return;
    }
    findPath(root.left,  c, list, '0');
    findPath(root.right, c, list, '1');
    list.removeLast();
  }

  public static void main(String[] args) {
    encode(null, "AAAAAABCCCCCCDDEEEEE");
  }
}
