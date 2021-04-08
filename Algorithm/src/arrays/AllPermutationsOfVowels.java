package arrays;

public class AllPermutationsOfVowels {

    private static final int MOD = 1000000007;

    public static int countVowelPermutation(int n) {
        long[] current = {1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            long[] next = {0, 0, 0, 0, 0};
            // Each vowel 'a' may only be followed by an 'e'.
            next[1] += current[0];
            // Each vowel 'e' may only be followed by an 'a' or an 'i'.
            next[0] += current[1];
            next[2] += current[1];
            // Each vowel 'i' may not be followed by another 'i'.
            next[0] += current[2];
            next[1] += current[2];
            next[3] += current[2];
            next[4] += current[2];
            // Each vowel 'o' may only be followed by an 'i' or'u'.
            next[2] += current[3];
            next[4] += current[3];
            // Each vowel 'u' may only be followed by an 'a'.
            next[0] += current[4];
            // assign
            current[0] = next[0] % MOD;
            current[1] = next[1] % MOD;
            current[2] = next[2] % MOD;
            current[3] = next[3] % MOD;
            current[4] = next[4] % MOD;
        }
        return (int) ((current[0] + current[1] + current[2] + current[3] + current[4]) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(1));
        System.out.println(countVowelPermutation(2));
        System.out.println(countVowelPermutation(5));
        System.out.println(countVowelPermutation(20000));
    }
}
