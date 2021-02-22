package strings;

public class BalancedBracket {

    private static boolean isBalanced(char[] exp) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[{()}]".toCharArray()) ? "Balanced" : "Not Balanced");
    }
}
