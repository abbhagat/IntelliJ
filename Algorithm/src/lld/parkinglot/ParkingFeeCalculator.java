package lld.parkinglot;

public class ParkingFeeCalculator {

  static double calculateFee(long duration, String vehicleType) {
    if ("CAR".contentEquals(vehicleType)) {
      return new CarFeeStrategy().calculate(duration);
    }
    return 0;
  }
}
