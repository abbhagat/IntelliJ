package geeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The time and space complexity of the `nextPalindromeDate` method in the `PalindromeDate` class is as follows:
 * Time Complexity : O(D), where D is the number of days it takes to find the next palindrome date.
 * In the worst case, this could be a large number, but it is bounded by the number of days in a year (365 or 366).
 * Space Complexity : O(1), as it uses a constant amount of extra space regardless of the input size.
 */
public class PalindromeDate {

  private static String nextPalindromeDate(String inputDate) throws ParseException {
    Calendar cal = Calendar.getInstance();
    int year     = Integer.parseInt(inputDate.substring(0, 4));
    int month    = Integer.parseInt(inputDate.substring(4, 6)) - 1;
    int day      = Integer.parseInt(inputDate.substring(6));
    cal.set(year, month, day);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String dateStr;
    while (true) {
      Date date = cal.getTime();
      dateStr   = sdf.format(date);
      StringBuilder revDateStr = new StringBuilder(dateStr).reverse();
      if (dateStr.contentEquals(revDateStr)) {
        break;
      }
      cal.add(Calendar.DATE, 1);
    }
    return dateStr;
  }

  public static void main(String[] args) throws ParseException {
    System.out.println("Next Palindrome Date :" + nextPalindromeDate("20250404"));
    System.out.println("Next Palindrome Date :" + nextPalindromeDate("20250205"));
  }
}
