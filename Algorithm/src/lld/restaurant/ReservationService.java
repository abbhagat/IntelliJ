package lld.restaurant;

import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IReservation {

  private final List<Booking> bookings = new ArrayList<>();

  public void save(Booking booking) {
    this.bookings.add(booking);
  }

  public List<Booking> getReservations() {
    return this.bookings;
  }

  public void cancel(Booking booking) {
    this.bookings.remove(booking);
  }
}
