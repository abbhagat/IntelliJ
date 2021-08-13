package java8.interfaces;

import java.time.Instant;
import java.time.LocalDate;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

public class StringToDateDemo {

    public static void main(String[] args) {
        System.out.println(Instant.parse("2007-12-03T10:15:30.00Z"));
        LocalDate localDate = parse("16-Aug-2016", ofPattern("dd-MMM-yyyy"));
        System.out.println(localDate);
    }
}
