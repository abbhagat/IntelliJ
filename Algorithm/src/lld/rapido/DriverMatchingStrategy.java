package lld.rapido;

import java.util.List;

public interface DriverMatchingStrategy {
  Driver findDriver(
      Location source,
      VehicleType vehicleType,
      List<Driver> drivers
  );
}
