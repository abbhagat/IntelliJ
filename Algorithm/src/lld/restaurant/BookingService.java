package lld.restaurant;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookingService {

  private final ReservationService reservationService;

  // One lock for each table
  private final Map<String, Lock> locks = new ConcurrentHashMap<>();

  public BookingService(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  public Booking book(Table table, String customer, LocalDateTime startTime, LocalDateTime endTime) {
    String key = String.join("", table.tableId(), startTime.toString(), endTime.toString());
    Lock lock = locks.computeIfAbsent(key, value -> new ReentrantLock());
    lock.lock();  // The code below this will not execute for same Table booking because lock is acquired by another Thread
    try {
      for (Booking booking : reservationService.getReservations()) {
        if (booking.table().tableId().equals(table.tableId()) && overlap(startTime, endTime, booking.startTime(), booking.endTime())) {
          System.out.println("Table already booked");
        }
      }
      int bookingId   = reservationService.getReservations().size() + 1;
      Booking booking = new Booking(bookingId, table, customer,  startTime, endTime);
      reservationService.save(booking);
      return booking;
    } finally {
      lock.unlock();
    }
  }

  private boolean overlap(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime reservedStartTime, LocalDateTime reservedEndTime) {
    return startTime.isBefore(reservedEndTime) && reservedStartTime.isBefore(endTime);
  }

  public boolean cancelBooking(Booking booking) {
    return reservationService.cancel(booking);
  }
}
