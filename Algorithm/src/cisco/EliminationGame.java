package cisco;

public class EliminationGame {

    private static int lastRemaining(int n) {
        int start = 1, step = 2;
        boolean isFromLeft = true;
        while (n != 1) {
            n >>= 1;
            start = isFromLeft ? start + step * n - step / 2 : start - step * n + step / 2;
            step <<= 1;
            isFromLeft = !isFromLeft;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
    }
}
