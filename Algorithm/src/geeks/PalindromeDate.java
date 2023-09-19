package geeks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PalindromeDate {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr;
        while (true) {
            dateStr = sdf.format(date);
            if (dateStr.contentEquals(new StringBuilder(dateStr).reverse())) {
                System.out.print("Next Palindrome Date " + sdf.format(date) + "\n");
                break;
            }
            c.add(Calendar.DATE, 1); // number of days to add
            date = c.getTime();
        }
    }
}
