package geeks;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static util.CommonUtils.isPalindrome;

// Time Complexity : O(N) If the next palindrome date is N days
// Space Complexity: O(1)
public class NextPalindromeDate {

  private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

  private static String nextPalindromeDate(String inputDate) {
    LocalDate date = LocalDate.parse(inputDate, INPUT_FORMAT);
    while (true) {
      String dateStr = date.format(OUTPUT_FORMAT);
      if (isPalindrome(dateStr)) {
        return dateStr;
      }
      date = date.plusDays(1);
    }
  }

  public static void main(String[] args) throws ParseException {
    System.out.println("Next Palindrome Date :" + nextPalindromeDate("2025-04-04"));
    System.out.println("Next Palindrome Date :" + nextPalindromeDate("2025-02-05"));
  }
}
