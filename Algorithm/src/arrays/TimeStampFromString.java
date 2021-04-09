package arrays;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampFromString {

    private static Timestamp getTimeStampFromString(String strDate, String format) throws Exception {
        java.sql.Timestamp timeStampDate = null;
        try {
            DateFormat formatter = new SimpleDateFormat(format);
            Date date = formatter.parse(strDate);
            timeStampDate = new Timestamp(date.getTime());
        } catch (ParseException e) {
            throw e;
        }
        return timeStampDate;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(getTimeStampFromString("09/30/2016", "MM/dd/yyyy"));
        //System.out.println(getTimeStampFromString("09/30/2016","yyyy-MM-dd"));
    }
}
