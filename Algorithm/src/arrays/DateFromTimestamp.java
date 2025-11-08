package arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFromTimestamp {

    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
    }
}
