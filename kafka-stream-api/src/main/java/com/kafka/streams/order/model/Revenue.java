package com.kafka.streams.order.model;

import java.math.BigDecimal;

public record Revenue(String locationId, BigDecimal totalAmount) {}