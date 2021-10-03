package paypal;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Paypal {

    public static void main(String[] args) throws IOException {
        List<Integer> tickets = Arrays.asList(10, 12, 1, 10, 4);
        Collections.sort(tickets);
        System.out.println(tickets);
        int x = 0, y = 0;
        for (int i = 1; i < tickets.size(); i++) {
            if (tickets.get(i) - tickets.get(i - 1) == 0 || tickets.get(i) - tickets.get(i - 1) == 1) {
                x++;
            } else {
                y++;
            }
        }
        System.out.println(x > y ? x : y);
    }

    public static int numSundaysOnFirst(int year) {
        int sundays = 0;
        if (LocalDate.of(year, 1, 7).getDayOfWeek() == DayOfWeek.SUNDAY) {
            sundays++;
        }
        return sundays + 1;
    }
}
