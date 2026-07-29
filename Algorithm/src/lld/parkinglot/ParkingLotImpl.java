package lld.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotImpl {

  public static void main(String[] args) throws InterruptedException {
    ParkingLot parkingLot = new ParkingLot();                // Create parking lot instance
    ParkingFloor parkingFloor = new ParkingFloor(1);  // Create a parking floor
    List<ParkingSpot> carSpots = new ArrayList<>();         // Create parking spots
    carSpots.add(new ParkingSpot("S1", SpotType.CAR, true, null));
    carSpots.add(new ParkingSpot("S2", SpotType.CAR, true, null));
    carSpots.add(new ParkingSpot("S3", SpotType.CAR, true, null));
    parkingFloor.getParkingSpotMap().put(SpotType.CAR, carSpots);
    parkingLot.getParkingFloors().add(parkingFloor);                            // Add floor to parking lot
    Vehicle vehicle = new Car("KA01MS1210", VehicleType.CAR);  // Create vehicle
    ParkingTicket parkingTicket = parkingLot.parkVehicle(vehicle);           // Park vehicle
    System.out.println("Vehicle parked. Ticket ID: " + parkingTicket);
    Thread.sleep(2000);                             // Simulate parking duration
    double fee = parkingLot.unParkVehicle(parkingTicket);   // Un park vehicle
    System.out.println("Vehicle un-parked Fee: " + fee);
  }
}
