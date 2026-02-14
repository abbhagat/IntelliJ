package lld.parkinglot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {

  private String spotId;
  private SpotType type;
  private boolean isFree;
  private Vehicle parkedVehicle;

  public synchronized boolean park(Vehicle vehicle) {
    if (!isFree || !vehicle.getType().name().equals(type.name())) {
      return false;
    }
    this.parkedVehicle = vehicle;
    this.isFree = false;
    return true;
  }

  public synchronized void unPark() {
    this.parkedVehicle = null;
    this.isFree = true;
  }
}
