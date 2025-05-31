package geeks;

/**
You have infinite number of Rs 3 coins and Rs 5 coins.
And you are provided one random number, and you need to find whether you can make the amount with both denominations.
Examples:
	23 = 5*4 +3*1 = 23, so true
	19 = 5*2+3*3 so true
	16 = 5*2+3*2 so true
	17 = 5*1 + 3*4 so true
*/

public class MakingDenominationOfARandomNum {

    public static void isSumOfCoins(int x, int y, int n) {
        if (x > n && y > n) {
            return;
        }
        if (n % x == 0) {
            System.out.println(x + " * " + n / x + " + 0 *" + y + " = " + n);
            return;
        }
        if (n % y == 0) {
            System.out.println(y + " * " + n / y + " + 0 *" + x + " = " + n);
            return;
        }
        int i = 1, k;
        while (true) {
            int num = n - (x * i);
            if (num % y == 0) {
                k = num / y;
                break;
            }
            i++;
        }
        System.out.println(x + " * " + i + " + " + y + " * " + k + " = " + n);
    }

    public static void main(String[] args) {
        isSumOfCoins(3, 5, 1);
        isSumOfCoins(3, 5, 19);
        isSumOfCoins(3, 5, 23);
        isSumOfCoins(3, 5, 16);
        isSumOfCoins(3, 5, 17);
        isSumOfCoins(3, 5, 103);
        isSumOfCoins(3, 5, 113);
    }
}
