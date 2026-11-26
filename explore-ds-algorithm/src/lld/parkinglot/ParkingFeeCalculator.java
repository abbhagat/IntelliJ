package lld.parkinglot;

public class ParkingFeeCalculator {

  static double calculateFee(long parkDuration, String vehicleType) {
    return switch (VehicleType.valueOf(vehicleType)) {
      case CAR  -> new CarFeeStrategy().calculate(parkDuration);
      case BIKE -> new BikeFeeStrategy().calculate(parkDuration);
      default   -> 0.0;
    };
  }
}
