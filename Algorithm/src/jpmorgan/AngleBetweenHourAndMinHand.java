package jpmorgan;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class AngleBetweenHourAndMinHand {

  private static int calcAngle(int hr, int min) {
    if (hr < 0 || hr > 12 || min < 0 || min > 60) {
      System.out.println("Wrong input");
      return -1;
    }
    if (hr == 12) {
      hr = 0;
    }
    if (min == 60) {
      min = 0;
      hr++;
    }
    int hourAngle = (int) (0.5 * (hr * 60 + min)); // hr hand moves by 360 degree in 12 hrs. So, in 1 min it moves by 0.5 degree
    int minsAngle = 6 * min;   // mins hand moves by 360 degree in 60 mins So, in 1 min it moves by 6 degree
    int angle = abs(hourAngle - minsAngle);
    return min(360 - angle, angle);
  }

  public static void main(String[] args) {
    System.out.println(calcAngle(8,  60) + " degree");
    System.out.println(calcAngle(9,  60) + " degree");
    System.out.println(calcAngle(3,  30) + " degree");
    System.out.println(calcAngle(3,  0)  + " degree");
    System.out.println(calcAngle(12, 30) + " degree");
    System.out.println(calcAngle(12, 60) + " degree");
  }
}
