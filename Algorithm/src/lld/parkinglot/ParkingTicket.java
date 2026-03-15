package lld.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ParkingTicket {

  private String ticketId;
  private String vehicleNumber;
  private long entryTime;
  private ParkingSpot spot;

  @Override
  public String toString() {
    return ticketId + "\t" + vehicleNumber + "\t" + new Date(entryTime) + "\t" + spot;
  }
}
