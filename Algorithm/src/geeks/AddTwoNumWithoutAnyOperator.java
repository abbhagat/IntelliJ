package geeks;

public class AddTwoNumWithoutAnyOperator {

    private static int sum(int x, int y) {
        while (y != 0) {
            int carry = (x & y) << 1;
            x = x ^ y;
            y = carry;
        }
        return x;
    }

    private static int add(int x, int y) {
        return y == 0 ? x : add(x ^ y, (x & y) << 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(13, 5));
        System.out.println(add(13, 5));
        System.out.println(sum(0, 5));
        System.out.println(add(0, 5));
        System.out.println(add(5, 0));
    }
}
