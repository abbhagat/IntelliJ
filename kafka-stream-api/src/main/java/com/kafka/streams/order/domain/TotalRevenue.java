package com.kafka.streams.order.domain;

import java.math.BigDecimal;

public record TotalRevenue(String locationId, Integer runningOrderCount, BigDecimal runningRevenue) {}