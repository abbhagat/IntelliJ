package medium;

import java.util.*;

public class DNASequence {

    private static List<String> findRepeatedDNASeq(String str) {
        if (str == null || str.isEmpty() || str.length() < 10) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        Set<String>  set  = new HashSet<>();
        for (int i = 0; i < str.length() - 10; i++) {
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
    }
}
