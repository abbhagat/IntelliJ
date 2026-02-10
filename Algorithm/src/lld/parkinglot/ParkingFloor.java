package lld.parkinglot;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingFloor {
  int floorNumber;
  Map<SpotType, List<ParkingSpot>> spots;

  ParkingFloor(int floorNumber) {
    this.floorNumber = floorNumber;
    spots = new HashMap<>();
  }

  ParkingSpot getFreeSpot(SpotType type) {
    for (ParkingSpot spot : spots.get(type)) {
      if (spot.isFree()) return spot;
    }
    return null;
  }
}
