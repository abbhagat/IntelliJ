package lld.parkinglot;

import java.util.concurrent.TimeUnit;

public class CarFeeStrategy implements FeeStrategy {

  @Override
  public double calculate(long parkDuration) {
    long hours = TimeUnit.MILLISECONDS.toHours(parkDuration);
    return Math.max(1, hours) * 50;
  }
}
