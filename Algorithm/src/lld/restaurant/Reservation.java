package lld.restaurant;

import java.time.LocalDateTime;

public record Reservation(int id, Table table, String customerName, LocalDateTime startTime, LocalDateTime endTime) {}
