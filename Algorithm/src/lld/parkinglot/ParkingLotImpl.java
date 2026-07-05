package lld.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotImpl {

  public static void main(String[] args) throws InterruptedException {

    // Get parking lot instance
    ParkingLot parkingLot = ParkingLot.getInstance();

    // Create a parking floor
    ParkingFloor floor1 = new ParkingFloor(1);

    // Create parking spots
    List<ParkingSpot> carSpots = new ArrayList<>();
    carSpots.add(new ParkingSpot("S1", SpotType.CAR, true, null));
    carSpots.add(new ParkingSpot("S2", SpotType.CAR, true, null));
    carSpots.add(new ParkingSpot("S3", SpotType.CAR, true, null));

    floor1.getSpots().put(SpotType.CAR, carSpots);

    // Add floor to parking lot
    parkingLot.getParkingFloors().add(floor1);

    // Create vehicle
    Vehicle vehicle = new Car("KA01MS1210", VehicleType.CAR);

    // Park vehicle
    ParkingTicket parkingTicket = parkingLot.parkVehicle(vehicle);
    System.out.println("Vehicle parked. Ticket ID: " + parkingTicket);

    // Simulate parking duration
    Thread.sleep(2000);

    // Unpark vehicle
    double fee = parkingLot.unParkVehicle(parkingTicket);

    System.out.println("Vehicle unparked. Fee: " + fee);
  }

}
