package lld.restaurant;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ReservationService implements IReservation {

  private final List<Booking> bookings = new CopyOnWriteArrayList<>();

  public void save(Booking booking) {
    this.bookings.add(booking);
  }

  public List<Booking> getReservations() {
    return this.bookings;
  }

  public boolean cancel(Booking booking) {
    return this.bookings.remove(booking);
  }
}
