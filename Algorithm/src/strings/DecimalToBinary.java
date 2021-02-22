package strings;

public class DecimalToBinary {

    private static String decimalToBinary(String binary, int mask, int num) {
        if (mask != 0) {
            binary += (num & mask) == 0 ? 0 : 1;
            return decimalToBinary(binary, mask >> 1, num);
        }
        return binary;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary("", 32768, 15));
        System.out.println(decimalToBinary("", 32768, 10));
    }
}
