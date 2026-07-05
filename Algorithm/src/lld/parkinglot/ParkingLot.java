package lld.parkinglot;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ParkingLot {

  private static ParkingLot parkingLot;

  private List<ParkingFloor> parkingFloors;
  private Map<String, ParkingTicket> activeTickets;

  private ParkingLot() {
    parkingFloors = new ArrayList<>();
    activeTickets = new ConcurrentHashMap<>();
  }

  public static synchronized ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  private ParkingTicket generateParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
    String ticketId = UUID.randomUUID().toString();
    String vehicleNumber = vehicle.getVehicleNumber();
    long entryTime = System.currentTimeMillis();
    return new ParkingTicket(ticketId, vehicleNumber,entryTime, parkingSpot);
  }

  public ParkingTicket parkVehicle(Vehicle vehicle) {
    for (ParkingFloor parkingFloor : parkingFloors) {
      String vehicleType = vehicle.getType().name();
      SpotType spotType  = SpotType.valueOf(vehicleType);
      ParkingSpot spot   = parkingFloor.getFreeSpot(spotType);
      if (spot != null) {
        spot.park(vehicle);
        ParkingTicket ticket = generateParkingTicket(spot, vehicle);
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
      }
    }
    throw new RuntimeException("Parking Full");
  }

  public double unParkVehicle(ParkingTicket parkingTicket) {
    ParkingTicket ticket = activeTickets.get(parkingTicket.getTicketId());
    if (ticket == null) {
      throw new RuntimeException("Invalid Ticket");
    }
    ticket.getParkingSpot().unPark();
    activeTickets.remove(parkingTicket.getTicketId());
    long duration = System.currentTimeMillis() - ticket.getEntryTime();
    ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
    Vehicle parkedVehicle = parkingSpot.getParkedVehicle();
    String vehicleType = parkedVehicle.getType().name();
    return ParkingFeeCalculator.calculateFee(duration, vehicleType);
  }
}
