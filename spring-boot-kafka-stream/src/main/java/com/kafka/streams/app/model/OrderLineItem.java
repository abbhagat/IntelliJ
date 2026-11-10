package com.kafka.streams.app.model;

import java.math.BigDecimal;

public record OrderLineItem(String item, Integer count, BigDecimal amount) {}