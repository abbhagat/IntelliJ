package geeks;

/**
 * You have infinite number of Rs 3 coins and Rs 5 coins.
 * And you are provided one random number, and you need to find whether you can make the amount with both denominations.
 * Examples:
 * 19 = 3 * 3 + 5 * 2
 * 23 = 3 * 1 + 5 * 4
 * 16 = 3 * 2 + 5 * 2
 * 17 = 3 * 4 + 5 * 1
 * 103 = 3 * 1 + 5 * 20
 * 113 = 3 * 1 + 5 * 22
 */

public class MakingDenominationOfARandomNum {

  public static void isSumOfCoins(int x, int y, int n) {
    if (x > n && y > n || n == 4) {
      System.out.println("Cannot form Denomination");
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
    isSumOfCoins(3, 5, 4);
    isSumOfCoins(3, 5, 19);
    isSumOfCoins(3, 5, 23);
    isSumOfCoins(3, 5, 16);
    isSumOfCoins(3, 5, 17);
    isSumOfCoins(3, 5, 103);
    isSumOfCoins(3, 5, 113);
  }
}
