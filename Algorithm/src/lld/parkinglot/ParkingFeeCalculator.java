package lld.parkinglot;

public class ParkingFeeCalculator {

  static double calculateFee(long parkDuration, String vehicleType) {
    return switch (vehicleType) {
      case "CAR" -> new CarFeeStrategy().calculate(parkDuration);
      default -> 0;
    };
  }
}
