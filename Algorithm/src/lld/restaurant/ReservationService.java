package lld.restaurant;

import java.util.ArrayList;
import java.util.List;

public class ReservationService implements IReservation {

  private final List<Reservation> reservations = new ArrayList<>();

  public void save(Reservation reservation) {
    this.reservations.add(reservation);
  }

  public List<Reservation> getReservations() {
    return this.reservations;
  }

  public void cancel(Reservation reservation) {
    this.reservations.remove(reservation);
  }
}
