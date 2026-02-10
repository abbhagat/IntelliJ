package lld.parkinglot;

public interface FeeStrategy {
  double calculate(long duration);
}
