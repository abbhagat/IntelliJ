package lld.restaurant;

import java.util.List;

public interface IReservation {
  boolean save(Booking booking);
  List<Booking> getReservations();
  boolean cancel(Booking booking);
}
