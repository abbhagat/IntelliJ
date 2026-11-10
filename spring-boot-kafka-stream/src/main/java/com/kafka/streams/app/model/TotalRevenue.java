package com.kafka.streams.app.model;

import java.math.BigDecimal;

public record TotalRevenue(String locationId, Integer runningOrderCount, BigDecimal runningRevenue) {}