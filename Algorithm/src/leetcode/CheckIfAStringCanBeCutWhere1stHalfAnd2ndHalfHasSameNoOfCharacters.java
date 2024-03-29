package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfAStringCanBeCutWhere1stHalfAnd2ndHalfHasSameNoOfCharacters {

    public static boolean sameFrequencyCharactersInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int value : map.values()) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sameFrequencyCharactersInString("aaabb"));
        System.out.println(sameFrequencyCharactersInString("aababbb"));
        System.out.println(sameFrequencyCharactersInString("aaabbb"));
    }
}
