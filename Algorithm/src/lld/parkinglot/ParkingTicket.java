package lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParkingTicket {
  private String ticketId;
  private String vehicleNumber;
  private long entryTime;
  private ParkingSpot spot;
}
