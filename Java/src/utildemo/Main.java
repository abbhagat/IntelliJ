package utildemo;

import java.util.Calendar;

public class Main {

    void display(long l) {
        System.out.println("long");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.display(Integer.valueOf(5));
        new FinalClassDemo(10, "xyz", Calendar.getInstance().getTime());
    }
}
