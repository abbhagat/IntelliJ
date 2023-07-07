package amazon;

// a%b = a - int(a/b)*b
// n&1 == 0 ? Even : Odd

// Time  Complexity  O(1)
public class CheckOddOrEvenWithoutModulus {

    private static boolean check(int n) {
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println((n - (n / 2) * 2 == 0) ? "EVEN" : "ODD");
        System.out.println(check(1) ? "EVEN" : "ODD");
        System.out.println(check(2) ? "EVEN" : "ODD");
    }
}
