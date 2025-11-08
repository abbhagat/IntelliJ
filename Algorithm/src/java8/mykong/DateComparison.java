package java8.mykong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateComparison {

    public static void main(String[] args) {

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.of(2009, 12, 31);
        LocalDate date2 = LocalDate.of(2010, 1, 31);
        LocalDate date3 = LocalDate.of(2010, 1, 31);

        System.out.println("date2 equals date3 : " + date2.isEqual(date3));
        System.out.println(DateTimeFormatter.ofPattern("dd-MMM-yyyy").format(date1));

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        System.out.println("Is...");
        if (date1.isAfter(date2)) {
            System.out.println("Date1 is after Date2");
        }

        if (date1.isBefore(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.isEqual(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        System.out.println("CompareTo...");
        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 is before Date2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 is equal to Date2");
        } else {
            System.out.println("How to get here?");
        }
    }

}
