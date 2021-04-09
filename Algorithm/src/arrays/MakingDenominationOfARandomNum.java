package arrays;

/*
 * You have infinite number of 3Rs coins and 5Rs coins.
 * And your are provided one random number and u need to find
 * whether you can make the amount with both denominations.
	for example:
	U r given a number: 23 then 5*4 +3*1 = 23 so true
	U r given a number :16 then true. 5*2+3*3
	U r given a number :17 then true. 5*1 + 3*4
 */

public class MakingDenominationOfARandomNum {

    public static boolean isSumOfCoins(int a, int b, int n) {

        if (n % a == 0) {
            System.out.println(a+"*"+n/a+"+0*"+b);
            return true;
        }
        if (n % b == 0) {
            System.out.println(b+"*"+n/b+"+0*"+a);
            return true;
        }
        for (int i = 1; i <= b; i++) {
            int k = n - (b * i);
            if (k % a == 0) {
                System.out.println(a +"*" + k/a + "+" + b + "*" + i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSumOfCoins(3, 5, 19));
    }
}
