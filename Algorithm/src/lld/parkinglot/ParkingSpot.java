package lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParkingSpot {

  private String spotId;
  private SpotType spotType;
  private boolean isFree;
  private Vehicle parkedVehicle;

  public synchronized boolean park(Vehicle vehicle) {
    if (!isFree || !vehicle.getType().name().equals(spotType.name())) {
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
