package vmware;

import java.text.DecimalFormat;

public class ImplementPowerFunction {

  private static double powers(double x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    double result = 1;
    for (int i = 1; i <= n; i++) {
      result *= x;
    }
    return result;
  }

  private static double power(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    return x * power(x, --n);
  }

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#.##");
    System.out.println(df.format(power(2, 10)) + "\t" + df.format(powers(2, 10)));
    System.out.println(df.format(power(3, 3))  + "\t" + df.format(powers(3, 3)));
    System.out.println(df.format(power(2, -2)) + "\t" + df.format(powers(2, -2)));
    System.out.println(df.format(power(2, 0))  + "\t" + df.format(powers(2, 0)));
  }
}
