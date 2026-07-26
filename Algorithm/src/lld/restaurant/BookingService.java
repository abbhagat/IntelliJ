package lld.restaurant;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {

  private final ReservationService repository;

  // One lock for each table
  private final ConcurrentHashMap<Integer, ReentrantLock> locks = new ConcurrentHashMap<>();

  public BookingService(ReservationService reservationService) {
    this.repository = reservationService;
  }

  public Reservation book(Table table, String customer, LocalDateTime start, LocalDateTime end) {
    ReentrantLock lock = locks.computeIfAbsent(table.id(), id -> new ReentrantLock());
    lock.lock();
    try {
      for (Reservation reservation : repository.getReservations()) {
        if (reservation.table().id() == table.id() && overlap(start, end, reservation.startTime(), reservation.endTime())) {
          throw new RuntimeException("Table already booked");
        }
      }
      Reservation reservation = new Reservation(repository.getReservations().size() + 1, table, customer,  start, end);
      repository.save(reservation);
      return reservation;
    } finally {
      lock.unlock();
    }
  }

  private boolean overlap(LocalDateTime s1, LocalDateTime e1, LocalDateTime s2, LocalDateTime e2) {
    return s1.isBefore(e2) && s2.isBefore(e1);
  }
}
