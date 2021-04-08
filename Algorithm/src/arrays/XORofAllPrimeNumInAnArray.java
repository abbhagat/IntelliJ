package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XORofAllPrimeNumInAnArray {

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(R.readLine());
        int[] a = new int[n];
        String array = R.readLine();
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(array.split(" ")[i]);
        }
        int l = Integer.parseInt(R.readLine());
        int r = Integer.parseInt(R.readLine());
        System.out.println(count(a, n, l, r));
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int count(int[] a, int n, int l, int r) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = l; i <= r && (l >= 0 && r < n); i++) {
            if (isPrime(a[i])) {
                primeList.add(a[i]);
            }
        }
        int _xor = 0;
        if (primeList.size() > 0) {
            _xor = primeList.get(0);
            Iterator<Integer> itr = primeList.iterator();
            itr.next();
            while (itr.hasNext()) {
                _xor ^= itr.next();
            }
        }
        return _xor;
    }
}
