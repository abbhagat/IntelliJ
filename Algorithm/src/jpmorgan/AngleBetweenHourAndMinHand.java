package jpmorgan;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class AngleBetweenHourAndMinHand {

    private static int calcAngle(double hr, double min) {
        if (hr < 0 || min < 0 || hr > 12 || min > 60) {
            System.out.println("Wrong input");
            return -1;
        }
        if (hr == 12) {
            hr = 0;
        }
        if (min == 60) {
            min = 0;
            hr++;
            if (hr > 12) {
                hr = hr - 12;
            }
        }
        int hourAngle = (int) (0.5 * (hr * 60 + min));
        int minAngle  = (int) (6 * min);
        int angle = abs(hourAngle - minAngle);
        return min(360 - angle, angle);
    }

    public static void main(String[] args) {
        System.out.println(calcAngle(9, 60)  + " degree");
        System.out.println(calcAngle(3, 30)  + " degree");
        System.out.println(calcAngle(3,  0)  + " degree");
        System.out.println(calcAngle(12, 30) + " degree");
    }
}
