package arrays;

import static arrays.ToDecimalFromBinary.toDecimal;
import static geeks.ParseIntImplementation.parseInt;
import static geeks.ToBinaryFromDecimal.toBinary;

public class AddTwoBinaryStringAndPrintTheResultInBinaryString {

    public static void main(String[] args) {
        String x = "1111";
        String y = "1010";
        int a = toDecimal(parseInt(x));
        int b = toDecimal(parseInt(y));
        int c = a + b;
        String z = toBinary(c);
        System.out.println(z);
    }
}
