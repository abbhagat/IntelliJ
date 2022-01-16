package recursion;

public class DecimalToBinary {

    private static String decimalToBinary(int num, int mask, String binaryString) {
        if (mask == 0) {
            return binaryString;
        }
        binaryString += (num & mask) == 0 ? 0 : 1;
        return decimalToBinary(num, mask >> 1, binaryString);
    }

    public static void main(String[] args) {
        String binaryString = decimalToBinary(35, 32768, "");
        System.out.println(binaryString);
        System.out.println(binaryString.substring(binaryString.indexOf("1")));
    }
}
