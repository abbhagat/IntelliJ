package lld.restaurant;

import java.time.LocalDateTime;

public record Booking(int bookingId,
                      Table table,
                      String customerName,
                      LocalDateTime startTime,
                      LocalDateTime endTime) {}
