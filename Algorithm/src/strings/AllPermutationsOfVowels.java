package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPermutationsOfVowels {

    private int mod = 1000000007;

    Map<Character, List<Character>> map = new HashMap<>();

    {
        map.put('a', Arrays.asList('e'));
        map.put('e', Arrays.asList('a', 'i'));
        map.put('i', Arrays.asList('a', 'e', 'o', 'u'));
        map.put('o', Arrays.asList('i', 'u'));
        map.put('u', Arrays.asList('a'));
    }

    public int countVowelPermutation(int n) {
        int[][] arr = new int[5][n];
        int count = 0;
        for (char c : map.keySet()) {
            count = (count + countStrings(arr, c, 1, n)) % mod;
        }
        return count;
    }

    private int countStrings(int[][] arr, char c, int i, int n) {
        if (i == n) {
            return 1;
        } else {
            if (arr[charIndex(c)][i - 1] > 0) {
                return arr[charIndex(c)][i - 1];
            }
            for (char ch : map.get(c)) {
                arr[charIndex(c)][i - 1] = (arr[charIndex(c)][i - 1] + countStrings(arr, ch, i + 1, n)) % mod;
            }
            return arr[charIndex(c)][i - 1];
        }
    }

    private int charIndex(char c) {
        return c == 'a' ? 0 : c == 'e' ? 1 : c == 'i' ? 2 : c == 'o' ? 3 : 4;
    }

    public static void main(String[] args) {
        AllPermutationsOfVowels v = new AllPermutationsOfVowels();
        System.out.println(v.countVowelPermutation(1));
    }
}
