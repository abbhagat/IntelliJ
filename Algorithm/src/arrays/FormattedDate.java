package goldmansach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormattedDate {

    static String getFormattedDate(String date) {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date oDate = sdFormat.parse(date);
            sdFormat = new SimpleDateFormat("MM/dd/yyyy");
            return (sdFormat.format(oDate));
        } catch (ParseException e) {
            return null;
        }

    }

    public static void main(String[] args) {
        System.out.println(getFormattedDate("07-OCT-1986"));
    }

}
