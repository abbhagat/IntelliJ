package com.kafka.streams.order.model;

import java.math.BigDecimal;

public record TotalRevenue(String locationId, Integer runningOrderCount, BigDecimal runningRevenue) {

  public TotalRevenue() {
    this("", 0, BigDecimal.ZERO);
  }

  public TotalRevenue calculateTotalRevenue(String key, Order order) {
    int newOrderCount = this.runningOrderCount + 1;
    BigDecimal newRunningRevenue = this.runningRevenue.add(order.totalAmount());
    return new TotalRevenue(key, newOrderCount, newRunningRevenue);
  }
}
