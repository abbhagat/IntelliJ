package jpmorgan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextDollarApp {

    private static final String CURRENCY_TYPE = "Dollars";

    private static final String ZERO_TEXT = "Zero";
    private static final String[] DIGITS_TEXT = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] TEENS_TEXT = { "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static final String[] TENS_TEXT = { "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private static final String[] BEYONDS_TEXT = { "", "Thousand", "Million" };
    private static final int ONE_BILLION = 1000000000;
    private static final String HUNDRED_TEXT = "Hundred";

    public static void main(String[] args) {
        if (args.length == 0) {
            try {
                prettyTextualPrinter("C:\\Users\\abbhagat\\Desktop\\A.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void prettyTextualPrinter(String filepath) throws IOException, RuntimeException {
        BufferedReader R = new BufferedReader(new FileReader(filepath));
        String s = null;
        while ((s = R.readLine()) != null) {
            String amountString = s.trim().replaceAll("\\s+", "");
            long amount = Long.parseLong(amountString);
            String amountWords = printInWords(amount);
            System.out.println(amountWords);
        }
    }

    private static String printInWords(long amount) {
        if (amount == 0)
            return ZERO_TEXT + CURRENCY_TYPE;

        StringBuilder amountInWords = new StringBuilder();
        int index = 0;
        while (amount > 0) {
            if (amount % 1000 != 0) {
                amountInWords.insert(0, amountPartToText((int)(amount % 1000)) + BEYONDS_TEXT[index]);
            }
            amount = amount / 1000;
            index++;
        }
        amountInWords.append(CURRENCY_TYPE);
        return amountInWords.toString();
    }

    private static String amountPartToText(int amountPart) {

        StringBuilder str = new StringBuilder();

        // 100s place conversion
        if (amountPart >= 100) {
            str.append(DIGITS_TEXT[amountPart / 100 - 1]);
            str.append(HUNDRED_TEXT);
            amountPart %= 100;
        }

        // tens place conversion
        if (amountPart >= 11 && amountPart <= 19) {
            return str.append(TEENS_TEXT[amountPart - 11]).toString();
        } else if (amountPart == 10 || amountPart >= 20) {
            str.append(TENS_TEXT[amountPart / 10 - 1]);
            amountPart %= 10;
        }

        // ones place conversion
        if (amountPart >= 1 && amountPart <= 9) {
            str.append(DIGITS_TEXT[amountPart - 1]);
        }
        return str.toString();
    }
}
