package gfg;

/**
 * Input : A[] = {2, 2, 1, 7, 5, 3}, k = 4
 * Output : 5
 * Explanation :
 * There are five pairs possible whose count
 * is divisible by '4' i.e., (2, 2),
 * (1, 7), (7, 5), (1, 3) and (5, 3)
 * <p>
 * Input : A[] = {5, 9, 36, 74, 52, 31, 42}, k = 3
 * Output : 7
 * An efficient approach is to use Hashing technique. We will separate elements into buckets depending on their (value mod K).
 * When a number is divided by K then the remainder may be 0, 1, 2, upto (k-1).
 * So take an array say freq[] of size K (initialized with Zero) and increase the value of freq[A[i]%K]
 * so that we can calculate the number of values giving remainder j on division with K.
 *
 *
 * In this approach we will use hashing method.What we are going to do is keep the elements in different cells of an array ,
 * this will be unique because we will separate them on the basis of their mod value with k.
 * When a number is divided by K then the remainder may be 0, 1, 2, upto (k-1).
 * We take an array remf[]of size k. At first we initialize each element with 0 and increase the value of remf[A[i]%K],
 * this calculates the occurrences of i mod k.
 *
 * remf[i] = number of elements with remainder i
 *
 * The key idea is to use r by K, then both R1 = 0 and R2 = 0. In this case, the remainder of dividing N1+N2 by K will also be 0.
 *
 *     If N1 is perfectly divisible by K but N2 is not, then R1 = 0 but R2 != 0. In this case, the remainder on dividing N1+N2 by K will be R2.
 *
 *     If both N1 and N2 are not divisible, then N1+N2 can be divisible by K only if R1 + R2 = K (or a multiple of K in general) and this is because K is perfectly divisible by K.
 *
 * Let us understand this:emf to get our answer. The idea is the a element from remf[i] will form a valid pair with a number from remf[j] if and only if:
 *  *
 *  * i + j = K or 0
 *  *
 *  * This is because consider two numbers N1 and N2 and a divisor K.
 *  If the remainder of N1 on dividing by K is R1 and similarly, the remainder of N2 is R2.
 *  *
 *  *     If N1 and N2 are divisible
 *
 * Let:
 *
 * A[] = {9,4,2,8,0}, K = 3
 *
 * This simply means we have to find the pairs whose sum is divisible by k=4;
 *
 * Now first we take an frequency array remf[] where shall store the frequecies of all the remainders when each number is divided by k.
 *
 * so its obvious that since we have taken k=3, so the remainders can maximum be 2 and min be 0 i.e [0,1,2]
 *
 * so when we iterate over each digit in array A[].
 * we get:
 *
 * i=0  A[i]=9  so 9%3=0  therefore remf[0]=1.
 *
 * i=1  A[i]=4  so 4%3=1  therefore remf[1]=1.
 *
 * i=2  A[i]=2  so 2%3=2  therefore remf[2]=1.
 *
 * i=3  A[i]=8  so 8%3=2  therefore remf[2]=2.
 *
 * i=4  A[i]=0  so 0%3=0  therefore remf[0]=2.
 *
 * so the hash table would look as such:
 * A[i] % k 	remf[ A[i] % k ]
 * 0 	2
 * 1 	1
 * 2 	2
 *
 * Now if a pair is to be divisible by k then the sum of the remainder's shall be equal to k or 0.
 *
 * So we consider the cases:
 *
 * When both the remainder's of the pair are 0:
 *
 * In such a case the number of valid pairs are remf[0] * remf[0]-1.
 * If there are n digits having 0 as their remainder, then the number of valid pairs are n*(n-1).
 *
 * When the sum of remainder's of the pair is equal to k:
 *
 * In such a case where the remainder's of the pair add upto make k.Then the pair is valid.
 *
 * And then we just put couple of conditions to check the hash table and find the pairs that add up and are divisible by 3.
 * Like, if we get a pair whose remainders are 1 and 2 then the pair can a valid pair because they add up to become 3 which is divisible by 3.
 * So Then we get an answer of 3 valid pairs for {9,4,2,8,0}
 *
 *
 */

public class FindPairCountWithSumDivisibleByK {

    private static final int[] a = {2, 2, 1, 7, 5, 3};

    private static int countKdivPairs(int k) {
        int[] freq = new int[k];
        for (int x : a) {
            freq[x % k]++;
        }
        int count = freq[0] * (freq[0] - 1) / 2;
        for (int i = 1; i <= k / 2 && i != (k - i); i++) {
            count += freq[i] * freq[k - i];
        }
        if (k % 2 == 0) {
            count += freq[k / 2] * (freq[k / 2] - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(countKdivPairs(4));
    }
}
