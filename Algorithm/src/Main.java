import static java.lang.Integer.min;

public class Main {

    private static int gcd(int x, int y) {  // 5, 10
        return y == 0 ? x : gcd(y, x % y);
    }

    private static boolean canMeasure(int x, int y, int z) {
        return (z <= x || z <= y) && z % gcd(x, y) == 0;
    }

    private static int minSteps(int x, int y, int z) {
        int from = 0, to = 0, steps = 0, pour;
        while (from != z && to != z) {
            if(from == 0) {
                from = x;
            } else if(to == y) {
                to = 0;
            } else {
                pour = min(from, y - to);
                from -= pour;
                to   += pour;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(canMeasure(3, 5, 4) ? min(minSteps(3, 5, 4), minSteps(5, 3, 4)) : -1);
        System.out.println(canMeasure(5, 3, 3) ? min(minSteps(3, 5, 3), minSteps(5, 3, 3)) : -1);
    }
}
