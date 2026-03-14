package lld.parkinglot;

import java.util.concurrent.TimeUnit;

public class CarFeeStrategy implements FeeStrategy {

  @Override
  public double calculate(long duration) {
    long hours = TimeUnit.MILLISECONDS.toHours(duration);
    return Math.max(1, hours) * 50;
  }
}
