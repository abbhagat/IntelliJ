package lld.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

  private static ParkingLot instance;
  List<ParkingFloor> floors;
  Map<String, ParkingTicket> activeTickets;

  private ParkingLot() {
    floors = new ArrayList<>();
    activeTickets = new ConcurrentHashMap<>();
  }

  public static synchronized ParkingLot getInstance() {
    if (instance == null) {
      instance = new ParkingLot();
    }
    return instance;
  }

  ParkingTicket parkVehicle(Vehicle vehicle) {
    for (ParkingFloor floor : floors) {
      ParkingSpot spot = floor.getFreeSpot(SpotType.valueOf(vehicle.getType().name()));
      if (spot != null) {
        spot.park(vehicle);
        ParkingTicket ticket = new ParkingTicket(
            UUID.randomUUID().toString(),
            vehicle.getLicenseNumber(),
            System.currentTimeMillis(),
            spot
        );
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
      }
    }
    throw new RuntimeException("Parking Full");
  }

  double unParkVehicle(String ticketId) {
    ParkingTicket ticket = activeTickets.get(ticketId);
    if (ticket == null) {
      throw new RuntimeException("Invalid Ticket");
    }

    ticket.getSpot().unPark();
    activeTickets.remove(ticketId);

    long duration = System.currentTimeMillis() - ticket.getEntryTime();
    return ParkingFeeCalculator.calculateFee(duration);
  }
}
