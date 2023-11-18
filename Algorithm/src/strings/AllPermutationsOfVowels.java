package strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPermutationsOfVowels {

    private int mod = 1000000007;

    Map<Character, List<Character>> map = new HashMap<>();
    {
        map.put('a', List.of('e'));
        map.put('e', List.of('a', 'i'));
        map.put('i', List.of('a', 'e', 'o', 'u'));
        map.put('o', List.of('i', 'u'));
        map.put('u', List.of('a'));
    }
    public int countVowelPermutation(int n) {
        int[][] a = new int[5][n];
        int count = 0;
        for (char c : map.keySet()) {
            count = (count + countStrings(a, c, 1, n)) % mod;
        }
        return count;
    }

    private int countStrings(int[][] a, char c, int i, int n) {
        if (i == n) {
            return 1;
        } else {
            if (a[charIndex(c)][i - 1] > 0) {
                return a[charIndex(c)][i - 1];
            }
            for (char ch : map.get(c)) {
                a[charIndex(c)][i - 1] = (a[charIndex(c)][i - 1] + countStrings(a, ch, i + 1, n)) % mod;
            }
            return a[charIndex(c)][i - 1];
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
