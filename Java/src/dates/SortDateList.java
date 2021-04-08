package dates;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Comparator.reverseOrder;

public class SortDateList {
    public static void main(String[] args) {
        List<Date> dates = Arrays.asList(new Date(300000000), new Date(1000000000), new Date(500000000), new Date(9000000), new Date(400000000));
        Collections.sort(dates, reverseOrder());
        dates.forEach(date -> System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(date)));
    }
}
