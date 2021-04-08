package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Complexity {

    public static void main(String[] args) throws IOException {
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(R.readLine());
        int i = n - 1;
        int j = n + 1;
        int x = 0;
        int y = 0;
        boolean iFlag = true;
        boolean jFlag = true;
        while (true) {
            if (i > 0 && i % 2 == 1 && isPrime(i) && iFlag) {
                x = i;
                iFlag = false;
            } else {
                i--;
            }
            if (j % 2 == 1 && isPrime(j) && jFlag) {
                y = j;
                jFlag = false;
            } else {
                j++;
            }
            if ((i + j) % n == 0) {
                System.out.println(i + j);
                break;
            } else {
                i--;
                j++;
                iFlag = true;
                jFlag = true;
            }
        }

    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
