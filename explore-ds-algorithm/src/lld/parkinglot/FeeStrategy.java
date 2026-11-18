package lld.parkinglot;

public interface FeeStrategy {
  long calculate(long parkDuration);
}
