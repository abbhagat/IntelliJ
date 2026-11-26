package lld.restaurant;

import java.util.List;

public interface IReservation {
  void save(Booking booking);
  List<Booking> getReservations();
  boolean cancel(Booking booking);
}
