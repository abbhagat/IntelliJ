package geeks;

/*
Given a string consisting of vowels and consonants. The task is to find the number of ways in which the characters of the string can be arranged
such that no two vowels are adjacent to each other.

Note: Given that No. of vowels <= No. of consonants.

Examples:

Input: str = "permutation" | geeksforgeeks"
Output : 907200           | 3175200

Approach: Consider the above example string “permutation”:

First place all of the consonants in the alternate places like below:
-- p -- r -- m -- t -- t -- n --
Number of ways to place consonants = 6! / 2!. as t  appears twice and should be considered once.
Then place the vowels in the remaining positions. We have 7 remaining positions and 5 vowels to fill these 7 places.
Therefore, the number of ways to fill vowels = 7C5*5!
Total no. of ways =  (6! / 2!) * 7C5*5! = 907200
Suppose, in a string, the number of vowels is vowelCount and the number of consonants is consonantCount.
Therefore,Total ways = (consonantCount! / duplicateConsonant!) * C(consonantCount+1 , vowelCount) * (vowelCount! / duplicateVowel!)
 */

public class StringPermutationWithNoTwoAdjacentVowels {

    private static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    private static int ncr(int n, int r) {  // Function to find c(n, r)
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private static int countWays(char[] c) {  // Function to count permutations of string such that no two vowels are adjacent
        int temp[] = new int[26];
        for(char x : c){
            temp[x - 'a']++;  // Finding the frequencies of the characters
        }
        int countVowels = 0, countConsonants = 0;
        for (int i = 0; i < 26; i++) {   // finding the no. of vowels and consonants in given word
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                countVowels += temp[i];
            } else {
                countConsonants += temp[i];
            }
        }
        int vplaces, cways, vways;
        vplaces = countConsonants + 1;  // finding places for the vowels
        cways = factorial(countConsonants);  // ways to fill consonants 6! / 2!
        for (int i = 0; i < 26; i++) {
            if (i != 0 && i != 4 && i != 8 && i != 14 && i != 20 && temp[i] > 1) {
                cways = cways / factorial(temp[i]);
            }
        }
        vways = ncr(vplaces, countVowels) * factorial(countVowels);  // ways to put vowels 7C5 x 5!
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20 && temp[i] > 1) {
                vways = vways / factorial(temp[i]);
            }
        }
        return cways * vways;
    }

    public static void main(String[] args) {
        System.out.println(countWays("permutation".toCharArray()));
    }
}
