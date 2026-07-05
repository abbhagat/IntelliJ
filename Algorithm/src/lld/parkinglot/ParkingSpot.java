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

  public synchronized void park(Vehicle vehicle) {
    if (!isFree || !vehicle.getVehicleType().name().equals(spotType.name())) {
      return;
    }
    this.parkedVehicle = vehicle;
    this.isFree = false;
  }

  public synchronized void unPark() {
    this.parkedVehicle = null;
    this.isFree = true;
  }

  @Override
  public String toString() {
    return spotId + "\t" + spotType.name() + "\t" + parkedVehicle;
  }
}
