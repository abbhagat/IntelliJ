package geeks;

public class PrimeNumber {

    public static boolean isPrime(int n) {
        if(n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(0)   ? "Prime" : "Not Prime");
        System.out.println(isPrime(1)   ? "Prime" : "Not Prime");
        System.out.println(isPrime(2)   ? "Prime" : "Not Prime");
        System.out.println(isPrime(13)  ? "Prime" : "Not Prime");
        System.out.println(isPrime(15)  ? "Prime" : "Not Prime");
        System.out.println(isPrime(101) ? "Prime" : "Not Prime");
    }
}
