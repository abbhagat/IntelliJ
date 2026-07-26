package lld.restaurant;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {

  private final ReservationRepository repository;

  // One lock for each table
  private final ConcurrentHashMap<Integer, ReentrantLock> locks = new ConcurrentHashMap<>();

  public BookingService(ReservationRepository reservationRepository) {
    this.repository = reservationRepository;
  }

  public Reservation book(Table table, String customer, LocalDateTime start, LocalDateTime end) {
    ReentrantLock lock = locks.computeIfAbsent(table.id(), id -> new ReentrantLock());
    lock.lock();  // The code below this will not execute for same Table booking because lock is acquired by another Thread
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

  private boolean overlap(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime reservedStartTime, LocalDateTime reservedEndTime) {
    return startTime.isBefore(reservedEndTime) && reservedStartTime.isBefore(endTime);
  }
}
