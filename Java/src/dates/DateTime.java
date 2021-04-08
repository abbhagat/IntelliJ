package dates;

import java.util.Calendar;
import java.util.Date;

public class DateTime {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date d1 = cal.getTime();
        cal.add(Calendar.HOUR, 1);
        Date d2 = cal.getTime();
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.before(d2));
        System.out.println(d2.after(d1));
        long timeDif = (d2.getTime() - d1.getTime()) / (1000 * 60 * 60);
        System.out.println(timeDif);
        cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        cal.add(Calendar.HOUR, -1);
        System.out.println(cal.getTime());
    }
}
