package lld.parkinglot;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import static lld.parkinglot.ParkingFeeCalculator.calculateFee;

@Getter
@Setter
public class ParkingLot {

  private List<ParkingFloor> parkingFloors;
  private Map<String, ParkingTicket> activeTickets;

  public ParkingLot() {
    parkingFloors = new ArrayList<>();
    activeTickets = new ConcurrentHashMap<>();
  }

  public ParkingTicket park(Vehicle vehicle) {
    for (ParkingFloor parkingFloor : parkingFloors) {
      String vehicleType = vehicle.getVehicleType().name();
      SpotType spotType  = SpotType.valueOf(vehicleType);
      ParkingSpot parkingSpot   = parkingFloor.getFreeSpot(spotType);
      if (parkingSpot != null) {
        parkingSpot.park(vehicle);
        ParkingTicket ticket = generateParkingTicket(parkingSpot, vehicle);
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
      }
    }
    throw new RuntimeException("Parking Full");
  }

  public double unPark(ParkingTicket parkingTicket) {
    ParkingTicket ticket = activeTickets.get(parkingTicket.getTicketId());
    if (ticket == null) {
      throw new RuntimeException("Invalid Ticket");
    }
    activeTickets.remove(parkingTicket.getTicketId());
    long parkDuration = System.currentTimeMillis() - ticket.getEntryTime();
    ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
    Vehicle parkedVehicle = parkingSpot.getParkedVehicle();
    String vehicleType = parkedVehicle.getVehicleType().name();
    ticket.getParkingSpot().unPark();
    return calculateFee(parkDuration, vehicleType);
  }

  private ParkingTicket generateParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
    String ticketId = UUID.randomUUID().toString();
    String vehicleNumber = vehicle.getVehicleNumber();
    long entryTime = System.currentTimeMillis();
    return new ParkingTicket(ticketId, vehicleNumber,entryTime, parkingSpot);
  }
}
