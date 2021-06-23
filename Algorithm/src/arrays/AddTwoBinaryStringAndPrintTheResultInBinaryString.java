package arrays;

import geeks.ToBinaryFromDecimal;

public class AddTwoBinaryStringAndPrintTheResultInBinaryString {

    public static void main(String[] args) {
        String x = "1111";
        String y = "1010";
        int a = ToDecimalFromBinary.toDecimal(ParseIntImplementation.parseInt(x));
        int b = ToDecimalFromBinary.toDecimal(ParseIntImplementation.parseInt(y));
        int c = a + b;
        String z = ToBinaryFromDecimal.toBinary(c);
        System.out.println(z);
    }
}
