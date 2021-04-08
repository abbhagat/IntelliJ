package javaa.datetime;

import java.time.LocalDate;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d  Month : %d  day : %d \t %n", year, month, day);
        System.out.println("Today's Local date : " + today);
        LocalDate dateOfBirth = LocalDate.of(1986, 10, 7);
        System.out.println("Your Date of birth is : " + dateOfBirth);
        LocalDate date1 = LocalDate.of(2017, 02, 9);
        if (date1.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }
    }
}
