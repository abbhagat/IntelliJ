package lld.parkinglot;

import java.util.concurrent.TimeUnit;
import static java.lang.Long.max;

public class CarFeeStrategy implements FeeStrategy {

  @Override
  public long calculate(long parkDuration) {
    long hours = TimeUnit.MILLISECONDS.toHours(parkDuration);
    return max(1, hours) * 50;
  }
}
