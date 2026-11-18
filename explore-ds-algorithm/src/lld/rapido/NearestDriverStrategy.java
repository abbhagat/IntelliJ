package lld.rapido;

import java.util.List;

public class NearestDriverStrategy implements DriverMatchingStrategy {

  @Override
  public Driver findDriver(Location source, VehicleType vehicleType, List<Driver> drivers) {
    Driver nearest = null;
    double minDistance = Double.MAX_VALUE;
    for (Driver driver : drivers) {
      if (driver.getStatus() != DriverStatus.AVAILABLE) {
        continue;
      }
      if (driver.getVehicle().type() != vehicleType) {
        continue;
      }
      double distance = source.distanceTo(driver.getLocation());
      if (distance < minDistance) {
        minDistance = distance;
        nearest = driver;
      }
    }
    return nearest;
  }
}
