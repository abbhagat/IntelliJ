package geeksforgeeks;

public class ReverseInteger {

  private static long reverse(long n) {
    long rev = 0;
    while (n != 0) {
      long k = n % 10;
      rev = rev * 10 + k;
      n /= 10;
    }
    return rev;

  }

  public static void main(String[] args) {
    System.out.println(reverse(123456789));
    System.out.println(reverse(-123456789));
    System.out.println(reverse(-12));
    System.out.println(reverse(-123));
    System.out.println(reverse(-1234));
    System.out.println(reverse(-12345));
  }
}
