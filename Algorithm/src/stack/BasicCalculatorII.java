package stack;

public class BasicCalculatorII {

    private static int calculate(String exp) {
        int lowVal, highVal, sign, priority, n;
        lowVal = highVal = priority = n = 0;
        sign = 1;
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
                if (i == exp.length() - 1 || !Character.isDigit(exp.charAt(i + 1))) {
                    highVal = (priority == 0 ? n : (priority == 1 ? highVal * n : highVal / n));
                }
            } else if (c == '*' || c == '/') {
                priority = c == '*' ? 1 : -1;
                n = 0;
            } else if (c == '+' || c == '-') {
                lowVal += sign * highVal;
                sign = c == '+' ? 1 : -1;
                priority = 0;
                n = 0;
            }
        }
        return lowVal + sign * highVal;
    }

    public static void main(String[] args) {
        System.out.println("3+2*2 = " + calculate("3+2*2"));
        System.out.println("3/2 = " + calculate("3/2"));
        System.out.println(" 3 +5 / 2 =" + calculate(" 3 +5 / 2"));
    }
}
