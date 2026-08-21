package lld.restaurant;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static lld.restaurant.TableStatus.AVAILABLE;

public class BookingImpl {

  public static void main(String[] args) throws Exception {

    Reservation reservation = new Reservation();
    BookingService bookingService = new BookingService(reservation);

    Table table1 = new Table("1", 5, AVAILABLE);
    Table table2 = new Table("2", 5, AVAILABLE);
    Table table3 = new Table("3", 5, AVAILABLE);
    Table table4 = new Table("4", 5, AVAILABLE);
    Table table5 = new Table("5", 5, AVAILABLE);

    Table[] tables = {table1, table2, table3, table4, table5};
    final int TOTAL_TABLE = tables.length;

    LocalDateTime start = LocalDateTime.of(2026, 7, 25, 19, 0);
    LocalDateTime end   = LocalDateTime.of(2026, 7, 25, 20, 0);

    ExecutorService executor = Executors.newFixedThreadPool(5);
    // 10 customers are trying to book the 5 available tables
    for (int i = 1; i <= 10; i++) {
      final int customerId = i;
      final Table table = tables[i % TOTAL_TABLE];
      executor.submit(() -> {
        try {
          Booking booking = bookingService.book(table, "Customer - " + customerId, start, end);
          System.out.println(Thread.currentThread().getName() + " booked Table " + booking.table().tableId());
        } catch (Exception e) {
          System.out.println(Thread.currentThread().getName() + " failed for Table " + table.tableId());
        }
      });
    }

    executor.shutdown();
    executor.awaitTermination(10, TimeUnit.SECONDS);
  }
}
