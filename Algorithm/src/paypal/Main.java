package paypal;

public class Main {

    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        int[] x = new int[num1.length()];
        int[] y = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            x[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            y[i] = num2.charAt(i) - '0';
        }
        int k = x.length + y.length;
        int[] mul = new int[k];
        for (int i = x.length - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = y.length - 1; j >= 0; j--) {
                int sum = x[i] * y[j] + carry + mul[k - 1];
                carry = sum / 10;
                mul[--k] = sum % 10;
            }
            mul[--k] = carry;
            k += y.length;
        }
        String result = "";
        for (int i = 0; i < mul.length; i++) {
            result += mul[i];
        }
        System.out.println(result);
    }
}
