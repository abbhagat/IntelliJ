package lld.parkinglot;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingFloor {

  private int floorNumber;
  private Map<SpotType, List<ParkingSpot>> parkingSpotMap;

  public ParkingFloor(int floorNumber, Map<SpotType, List<ParkingSpot>> parkingSpotMap) {
    this.floorNumber    = floorNumber;
    this.parkingSpotMap = parkingSpotMap;
  }

  public ParkingSpot getFreeSpot(SpotType spotType) {
    List<ParkingSpot> parkingSpotList = parkingSpotMap.get(spotType);
    for (ParkingSpot spot : parkingSpotList) {
      if (spot.isFree()) {
        return spot;
      }
    }
    return null;
  }
}
