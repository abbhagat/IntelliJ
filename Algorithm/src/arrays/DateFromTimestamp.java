package goldmansach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromTimestamp {

    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("dd-MMM-YYYY").format(new Date()));
    }
}
