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

  private List<ParkingFloor> floors;
  private Map<String, ParkingTicket> activeTickets;

  private ParkingLot() {
    floors = new ArrayList<>();
    activeTickets = new ConcurrentHashMap<>();
  }

  public static synchronized ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  public ParkingTicket parkVehicle(Vehicle vehicle) {
    for (ParkingFloor parkingFloor : floors) {
      ParkingSpot spot = parkingFloor.getFreeSpot(SpotType.valueOf(vehicle.getType().name()));
      if (spot != null) {
        spot.park(vehicle);
        ParkingTicket ticket = new ParkingTicket(UUID.randomUUID().toString(),
                                                 vehicle.getVehicleNumber(),
                                                 System.currentTimeMillis(),
                                                 spot
                                                );
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
    ticket.getSpot().unPark();
    activeTickets.remove(parkingTicket.getTicketId());
    long duration = System.currentTimeMillis() - ticket.getEntryTime();
    return ParkingFeeCalculator.calculateFee(duration, parkingTicket.getSpot().getParkedVehicle().getType().name());
  }
}
