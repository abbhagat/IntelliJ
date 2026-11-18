package lld.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotImpl {

  public static void main(String[] args) throws InterruptedException {
    ParkingLot parkingLot = new ParkingLot();                // Create parking lot instance

    Map<SpotType, List<ParkingSpot>> parkingSpotMap = new HashMap<>();  // Create parking spots
    List<ParkingSpot> carSpots = new ArrayList<>();
    carSpots.add(new ParkingSpot("S1", SpotType.CAR, true, null));
    carSpots.add(new ParkingSpot("S2", SpotType.CAR, true, null));
    carSpots.add(new ParkingSpot("S3", SpotType.CAR, true, null));
    parkingSpotMap.put(SpotType.CAR, carSpots);
    ParkingFloor parkingFloor = new ParkingFloor(1, parkingSpotMap);  // Create a parking floor

    parkingLot.getParkingFloors().add(parkingFloor);                            // Add floor to parking lot
    Vehicle vehicle = new Car("KA01MS1210", VehicleType.CAR);  // Create vehicle
    ParkingTicket parkingTicket = parkingLot.park(vehicle);           // Park vehicle
    System.out.println("Vehicle parked. Ticket ID: " + parkingTicket);
    Thread.sleep(2000);                      // Simulate parking duration
    double fee = parkingLot.unPark(parkingTicket);   // Un park vehicle
    System.out.println("Vehicle un-parked Fee: " + fee);
  }
}
