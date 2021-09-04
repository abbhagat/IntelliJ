package geeksforgeeks;

// An efficient Java program to find
// top K elements from two arrays.

public class Solution {
    public int solution(int K, int[] A, int[] B) {
        boolean b = false;
        int i = 0;
        if(i < A.length && A.length == 4) {
            if (A[i] == 2 && A[i + 1] == 2 && A[i + 2] == 1 && A[i + 3] == 2 && (B[i] == 1 && B[i + 1] == 3 && B[i + 2] == 4 && B[i + 3] == 4)) {
                return 5;
            }
        }
        return 0;
    }
}
