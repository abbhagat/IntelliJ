package adobe;

import java.util.HashSet;
import java.util.Set;

public class JewelAndStones {

  private static int numJewelsInStones(String jewels, String stones) {
    Set<Character> set = new HashSet<>();
    jewels.chars().forEach(c -> set.add((char) c));
    int count = 0;
    for (char c : stones.toCharArray()) {
      if (set.contains(c)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    System.out.println(numJewelsInStones("z",  "ZZ"));
  }
}
