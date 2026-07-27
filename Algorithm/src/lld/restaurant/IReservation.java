package lld.restaurant;

import java.util.List;

public interface IReservation {
  void save(Booking booking);
  List<Booking> getReservations();
  void cancel(Booking booking);
}
