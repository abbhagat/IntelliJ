package threads;

import java.util.Date;

class PerThreadFormatter {

    private static final ThreadLocal<Date> dateFormatHolder = new ThreadLocal<Date>() {

        /*
         * initialValue() is called
         */

        @Override
        protected Date initialValue() {
            System.out.println("Creating Date for Thread : " + Thread.currentThread().getName());
            return new Date();
        }
    };

    /*
     * Every time there is a call for DateFormat, ThreadLocal will return
     * calling Thread's copy of SimpleDateFormat
     */

    public static Date getDate() {
        return dateFormatHolder.get();
    }
}

class Thread1 extends Thread {

    private static final ThreadLocal<Date> date = new ThreadLocal<Date>();

    Thread1() {

    }

    public void run() {
        System.out.println(Thread.currentThread());
        // System.out.println(Thread.holdsLock(obj));
    }
}

class Thread2 extends Thread {

    public void run() {

    }

}

public class ThreadDemo {

    // public static String threadSafeFormat(Date date){
    // //DateFormat formatter = PerThreadFormatter.getDate();
    // //return formatter.format(date);
    // }

    public static void main(String[] args) {

    }

}
