package geeks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PalindromeDate {

    private static String nextPalindromeDate(String inputDate, String format) {
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(inputDate.substring(0, 4));
        int month = Integer.parseInt(inputDate.substring(4, 7));
        int day = Integer.parseInt(inputDate.substring(7));
        cal.set(year, month, day);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = cal.getTime();
        String dateStr;
        while (true) {
            dateStr = sdf.format(date);
            if (dateStr.contentEquals(new StringBuilder(dateStr).reverse())) {
                break;
            }
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();
        }
        return dateStr;
    }

    public static void main(String[] args) {
        System.out.println("Next Palindrome Date :" + nextPalindromeDate("20231215", "yyyyMMdd"));
    }
}
