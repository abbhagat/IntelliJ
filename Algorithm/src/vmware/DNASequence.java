package vmware;

import java.util.*;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class DNASequence {

  private static List<String> findRepeatedDNASeq(String str) {
    List<String> list = new ArrayList<>();
    if (str == null || str.length() < 10) {
      return list;
    }
    Set<String> set = new HashSet<>();
    for (int i = 0; i + 10 < str.length(); i++) {
      String s = str.substring(i, i + 10);
      if (set.contains(s)) {
        list.add(s);
      }
      set.add(s);
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(findRepeatedDNASeq("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    System.out.println(findRepeatedDNASeq("AAAAACCCCCAAAAACCCCCCAAAAAGGGKKK"));
  }
}
