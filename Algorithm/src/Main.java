public class Main {

    public static void main(String[] args) {

    }

    void slidingWindow() {
        int[] a = {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0};
        int k = 4;
        int wL, wR, zeroCount, startIndex, bestWindow;
        wL = wR = zeroCount = startIndex = bestWindow = 0;
        while (wR < a.length) {
            if (zeroCount <= k) {
                zeroCount += a[wR] == 0 ? 1 : 0;
                wR++;
            }
            if (zeroCount > k) {
                zeroCount -= a[wL] == 0 ? 1 : 0;
                wL++;
            }
            if (wR - wL > bestWindow && zeroCount <= k) {
                bestWindow = wR - wL;
                startIndex = wL;
            }
        }
        for (int i = startIndex; i < startIndex + bestWindow; i++) {
            if (a[i] == 0) {
                a[i] = 1;
                System.out.print(i + " ");
            }
        }
    }

    int countPairsWithSumDivByK(int[] a, int k) {
        int count = 0;
        int[] freq = new int[k];
        for (int x : a) {
            freq[x % k]++;
        }
        for (int i = 1; i <= k / 2 && i != k - i; i++) {
            count += freq[i] * freq[k - i];
        }
        count = freq[0] * (freq[0] - 1) / 2;
        if (k % 2 == 0) {
            count += freq[k / 2] * (freq[k / 2] - 1) / 2;
        }
        return count;
    }
}
