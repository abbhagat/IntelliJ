package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatDemo {

    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        System.out.println(new SimpleDateFormat("yyyy/MMM/dd").format(new Date()));
        System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime()));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2017-05-22"));
    }
}
