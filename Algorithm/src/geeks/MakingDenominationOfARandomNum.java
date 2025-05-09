package geeks;

/*
 * You have infinite number of 3Rs coins and 5Rs coins.
 * And you are provided one random number and u need to find
 * whether you can make the amount with both denominations.
	for example:
	U r given a number: 23 then 5*4 +3*1 = 23 so true
	U r given a number :19 then true. 5*2+3*3
	U r given a number :16 then true. 5*2+3*2
	U r given a number :17 then true. 5*1 + 3*4
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
            if ((n - (x * i)) % y == 0) {
                k = (n - (x * i)) / y;
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
    }
}
