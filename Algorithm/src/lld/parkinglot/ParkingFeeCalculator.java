package lld.parkinglot;

public class ParkingFeeCalculator {

  static double calculateFee(long duration) {
    return new CarFeeStrategy().calculate(duration);
  }
}
