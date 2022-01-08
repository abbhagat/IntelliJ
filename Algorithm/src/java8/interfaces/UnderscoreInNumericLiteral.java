package java8.interfaces;

public class UnderscoreInNumericLiteral {

    public static void main(String[] args) {
        // Underscore in integral literal
        int x = 10_000_0_0;
        int y = 20_000_00;
        System.out.println("x = " + x);
        System.out.println("x + y = " + (x + y));
        // Underscore in floating literal
        float b = 10.5_000f;
        System.out.println("b = " + b);
        // Underscore in binary literal
        int c = 0B10_10;
        System.out.println("c = " + c);
        // Underscore in hexadecimal literal
        int d = 0x1_1;
        System.out.println("d = " + d);
        // Underscore in octal literal
        int e = 01_1;
        System.out.println("e = " + e);

    }

}
