package arrays;

//a%b = a - int(a/b)*b

public class CheckOddOrEvenWithoutModulus {
    public static void main(String[] args) {
        int n = 5;
        System.out.println((n - (n / 2) * 2 == 0) ? "EVEN" : "ODD");
    }
}
