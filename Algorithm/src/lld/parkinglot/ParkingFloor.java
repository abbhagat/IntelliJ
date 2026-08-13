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

  public ParkingSpot getFreeParkingSpot(SpotType spotType) {
    List<ParkingSpot> parkingSpotList = parkingSpotMap.get(spotType);
    for (ParkingSpot parkingSpot : parkingSpotList) {
      if (parkingSpot.isFree()) {
        return parkingSpot;
      }
    }
    return null;
  }
}
