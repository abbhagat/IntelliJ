package arrays;

import java.io.BufferedReader;
import java.io.FileReader;

public class DollarToText {

    private static final String[] _1_to_9 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] _10_to_90 = new String[]{"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] _11_to_19 = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] _1000_to_million = new String[]{"", "Thousand", "Million"};
    private static final String _0 = "Zero";
    private static final String _100 = "Hundred";
    private static final String CURRENCY_TYPE = "Dollars";

    private static void printDollarToText(String filePath) throws Exception {
        BufferedReader R = new BufferedReader(new FileReader(filePath));
        String s;
        while ((s = R.readLine()) != null) {
            long amount = Long.parseLong(s);
            System.out.println(printText(amount));
        }
    }

    private static String printText(long amount) {
        if (amount == 0) {
            return _0 + CURRENCY_TYPE;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (amount > 0) {
            if (amount % 1000 != 0) {
                sb.insert(0, amountPartToText((int) (amount % 1000)) + _1000_to_million[i]);
            }
            amount = amount / 1000;
            i++;

        }
        return sb.append(CURRENCY_TYPE).toString();
    }

    private static String amountPartToText(int amount) {
        StringBuilder sb = new StringBuilder();
        if (amount >= 100) {
            sb.append(_1_to_9[(amount / 100) - 1]).append(_100);
            amount %= 100;
        }
        if (amount >= 11 && amount <= 19) {
            return sb.append(_11_to_19[amount - 11]).toString();
        } else if (amount == 10 || amount >= 20) {
            sb.append(_10_to_90[amount / 10 - 1]);
            amount %= 10;
        }
        if (amount >= 1 && amount <= 9) {
            sb.append(_1_to_9[amount - 1]);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        printDollarToText("C:\\Users\\abbhagat\\Desktop\\A.txt");
    }
}
