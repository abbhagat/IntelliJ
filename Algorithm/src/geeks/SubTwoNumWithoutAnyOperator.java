package geeks;

public class SubTwoNumWithoutAnyOperator {

    static int sub(int x, int y) {
        while (y != 0) {
            int carry = (x & y) >> 1;
            x = x ^ y;
            y = carry;
        }
        return x;
    }

    static int subtract(int x, int y) {
        return y == 0 ? x : subtract(x ^ y, (x & y) >> 1);
    }

    public static void main(String[] args) {
        System.out.println(sub(13, 5));
        System.out.println(subtract(13, 5));
    }

}
