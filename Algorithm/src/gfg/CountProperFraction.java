package gfg;

public class CountProperFraction {

    public static int countProperFractions(int d) {
        int count = 0;
        for (int i = 1; i < d; i++) {
            for (int j = i; j <= d; j++) {
                int hcf = findHCF(Math.min(i, j), Math.max(i, j));
                if (hcf == 1) {
                    count++;
                }
            }
        }
        return count - 1;
    }

    private static int findHCF(int x, int y) {
        return (y % x == 0) ? x : findHCF(y % x, x);
    }

    public static void main(String[] args) {
        System.out.println(countProperFractions(8));
    }
}
