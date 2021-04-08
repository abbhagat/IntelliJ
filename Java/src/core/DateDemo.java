package core;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

public class DateDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.format(ofPattern("ddMMyyyy")));
        System.out.println(localDate.format(ofPattern("MMddyyyy")));
        System.out.println(localDate.format(ofPattern("dd-MMM-yyyy")));
        System.out.println(localDate.format(ofPattern("dd/MMM/yyyy")));
        System.out.println(localDate.format(ofPattern("dd-MM-yyyy")));
    }
}
