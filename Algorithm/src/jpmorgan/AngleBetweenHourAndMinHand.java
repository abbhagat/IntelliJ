package jpmorgan;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class AngleBetweenHourAndMinHand {

    private static int calcAngle(double hr, double min) {
        if (hr < 0 || min < 0 || hr > 12 || min > 60) {
            System.out.println("Wrong input");
        }
        hr = hr == 12 ? 0 : hr;
        if (min == 60) {
            min = 0;
            hr++;
            hr -= hr > 12 ? 12 : 0;
        }
        int hourAngle = (int) (0.5 * (hr * 60 + min));   // Calculate the angles moved by hour and minute hands with reference to 12:00
        int minAngle  = (int) (6 * min);
        int angle     = abs(hourAngle - minAngle);     // Find the difference between two angles
        return min(360 - angle, angle);            // smaller angle of two possible angles
    }

    public static void main(String[] args) {
        System.out.println(calcAngle( 9, 60) + " degree");
        System.out.println(calcAngle( 3, 30) + " degree");
        System.out.println(calcAngle(12, 30) + " degree");
    }
}
