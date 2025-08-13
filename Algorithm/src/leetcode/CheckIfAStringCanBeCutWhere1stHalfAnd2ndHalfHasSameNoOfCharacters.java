package leetcode;

import java.util.*;

public class CheckIfAStringCanBeCutWhere1stHalfAnd2ndHalfHasSameNoOfCharacters {

    public static boolean sameFrequencyCharactersInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        str.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
        Set<Integer> set = new HashSet<>();
        return map.values().stream().allMatch(set::add);  // all elements added to the set must be unique
    }

    public static void main(String[] args) {
        System.out.println(sameFrequencyCharactersInString("aaabb"));
        System.out.println(sameFrequencyCharactersInString("aababbb"));
        System.out.println(sameFrequencyCharactersInString("aaabbb"));
    }
}
