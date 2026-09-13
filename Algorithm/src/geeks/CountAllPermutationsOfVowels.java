package geeks;

// Time  Complexity O(n)
// Space Complexity O(1)
public class CountAllPermutationsOfVowels {

  private static final int MOD = 1000000007;

  public static int countVowelPermutation(int n) {
    long a = 1, e = 1, i = 1, o = 1, u = 1;  // For a single vowel, there are 5 valid strings -> a, e, i, o, u
    long na, ne, ni, no, nu;
    for (int k = 2; k <= n; k++) {
      na = (e + i + u) % MOD;  // a can be preceded by e, i, or u
      ne = (a + i)     % MOD;  // e can be preceded by a or i
      ni = (e + o)     % MOD; // i can be preceded by e or o
      no =      i      % MOD; // o can be preceded by i
      nu = (i + o)     % MOD; // u can be preceded by i or o
      a = na;
      e = ne;
      i = ni;
      o = no;
      u = nu;
    }
    return (int) ((a + e + i + o + u) % MOD);
  }

  public static void main(String[] args) {
    System.out.println(countVowelPermutation(1));
    System.out.println(countVowelPermutation(2));
    System.out.println(countVowelPermutation(5));
    System.out.println(countVowelPermutation(20000));
  }
}
