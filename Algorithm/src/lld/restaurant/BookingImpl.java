package lld.restaurant;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BookingImpl {

  public static void main(String[] args) throws Exception {
    ReservationRepository repository = new ReservationRepository();

    BookingService bookingService = new BookingService(repository);

    Table table1 = new Table(1, 4, Status.AVAILABLE);
    Table table2 = new Table(2, 4, Status.AVAILABLE);
    Table table3 = new Table(3, 4, Status.AVAILABLE);

    Table[] tables = {table1, table2, table3};

    LocalDateTime start = LocalDateTime.of(2026, 7, 25, 19, 0);
    LocalDateTime end   = LocalDateTime.of(2026, 7, 25, 21, 0);

    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 1; i <= 5; i++) {
      final int customerId = i;
      final Table table = tables[(i - 1) % 3];
      executor.submit(() -> {
        try {
          Reservation reservation = bookingService.book(table, "Customer-" + customerId, start, end);
          System.out.printf("%s booked Table-%d%n", Thread.currentThread().getName(), reservation.table().id());
        } catch (Exception e) {
          System.out.printf("%s failed for Table-%d%n", Thread.currentThread().getName(), table.id());
        }
      });
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.SECONDS);
  }
}
