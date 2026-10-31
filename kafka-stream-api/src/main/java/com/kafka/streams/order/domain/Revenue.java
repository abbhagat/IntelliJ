package com.kafka.streams.order.domain;

import java.math.BigDecimal;

public record Revenue(String locationId, BigDecimal finalAmount) {}