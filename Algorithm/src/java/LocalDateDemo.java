package java;

import java.time.LocalDate;
import java.util.Date;

import static java.time.format.DateTimeFormatter.ofPattern;

public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.format(ofPattern("dd-MMM-yyyy")));
        LocalDate birthday = LocalDate.of(1986, 10, 7);
        System.out.println(birthday.compareTo(birthday));
        System.out.println(birthday.format(ofPattern("dd-MMM-yyyy")));
        Date date2 = new Date("07-OCT-1986");
        System.out.println(date2);
    }
}
