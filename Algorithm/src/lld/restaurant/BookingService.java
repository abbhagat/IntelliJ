package lld.restaurant;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {

  private final ReservationService repository;

  // One lock for each table
  private final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

  public BookingService(ReservationService reservationService) {
    this.repository = reservationService;
  }

  public Booking book(Table table, String customer, LocalDateTime start, LocalDateTime end) {
    String key = String.join("", table.tableId(), start.toString(), end.toString());
    ReentrantLock lock = locks.computeIfAbsent(key, keyId -> new ReentrantLock());
    lock.lock();  // The code below this will not execute for same Table booking because lock is acquired by another Thread
    try {
      for (Booking booking : repository.getReservations()) {
        if (booking.table().tableId().contentEquals(table.tableId()) && overlap(start, end, booking.startTime(), booking.endTime())) {
          throw new RuntimeException("Table already booked");
        }
      }
      Booking booking = new Booking(repository.getReservations().size() + 1, table, customer,  start, end);
      repository.save(booking);
      return booking;
    } finally {
      lock.unlock();
    }
  }

  private boolean overlap(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime reservedStartTime, LocalDateTime reservedEndTime) {
    return startTime.isBefore(reservedEndTime) && reservedStartTime.isBefore(endTime);
  }
}
