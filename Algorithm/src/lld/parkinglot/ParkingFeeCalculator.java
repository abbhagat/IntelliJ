package lld.parkinglot;

public class ParkingFeeCalculator {

  static double calculateFee(long parkDuration, String vehicleType) {
    if ("CAR".contentEquals(vehicleType)) {
      return new CarFeeStrategy().calculate(parkDuration);
    }
    return 0;
  }
}
