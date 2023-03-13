package arrays;

/*
 *
    Initialize mask variable with 32768 [1000 0000 0000 0000]
    Perform AND of two number s (i.e Given variable and  Mask variable )
    Check whether the Result of AND is 0 or not , if Yes Display 0 otherwise Display 1
    Right shift mask variable by 1 [0100 0000 0000 0000]
    Now check for Second bit , whether it is 0 or 1
    Goto step 3 until mask becomes Zero  [ 0000 0000 0000 0000 ]
 */

public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5)); // 32768 --> 1000000000000000
//        for (int num = 1; num <= 15; num++) {
//            int mask = 32768; // *4*16*16*16*2; // mask = [1000000000000000] -> Binary representation
//            while (mask != 0) {
//                System.out.print((num & mask) == 0 ? "0" : "1");
//                mask >>= 1;  // we need to check the status of each bit in the given number
//            }
//            System.out.println();
//        }
        System.out.println(decimalToBinary(5));
    }

    private static String decimalToBinary(int num) {
        StringBuilder binary = new StringBuilder();
        int carry = 0;
        while (num != 0) {
            carry = num / 2;
            binary.insert(0, num % 2);
            num /= 2;
        }
        return carry == 0 ? binary.toString() : "1" + binary;
    }
}
