package com.kafka.streams.app.model;

import java.math.BigDecimal;

public record Revenue(String locationId, BigDecimal totalAmount) {}