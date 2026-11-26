package lld.restaurant;

import java.time.LocalDateTime;

public record Booking(String bookingId, Table table, String customerName, LocalDateTime startTime, LocalDateTime endTime) {}
