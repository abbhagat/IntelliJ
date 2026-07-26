package lld.restaurant;

import java.util.List;

public interface IReservation {
  void save(Reservation reservation);
  List<Reservation> getReservations();
  void cancel(Reservation reservation);
}
