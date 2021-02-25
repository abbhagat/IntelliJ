package strings;

public class AllPermutationOfVowels {

    private static int countPermutationOfVowels(int n) {
        int[] current = {1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            int[] next = {0, 0, 0, 0, 0};  // {a,e,i,o,u}
            next[1] += current[0];        // a is followed by e only
            next[0] += current[1];        // e is followed by a and i only
            next[2] += current[1];
            next[0] += current[2];        // i is followed by a,e,o and u only
            next[1] += current[2];
            next[3] += current[2];
            next[4] += current[2];
            next[2] += current[3];       // o is followed by i and u only
            next[4] += current[3];
            next[0] += current[4];       // u is followed by a only
            for (int j = 0; j < 5; j++) {
                current[j] = next[j];
            }
        }
        int sum = 0;
        for (int x : current) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countPermutationOfVowels(1));
        System.out.println(countPermutationOfVowels(2));
        System.out.println(countPermutationOfVowels(5));
    }
}
