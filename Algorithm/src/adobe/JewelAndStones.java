package adobe;

import java.util.Set;
import java.util.stream.Collectors;

public class JewelAndStones {

  private static int numOfJewelsInStones(String jewels, String stones) {
    Set<Character> set = jewels.chars()
                               .mapToObj(c -> (char) c)
                               .collect(Collectors.toSet());
    int count = 0;
    for (char c : stones.toCharArray()) {
      if (set.contains(c)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numOfJewelsInStones("aA", "aAAbbbb"));
    System.out.println(numOfJewelsInStones("z",  "ZZ"));
  }
}
