package com.kafka.streams.order.model;

import java.math.BigDecimal;

public record OrderLineItem(String item, Integer count, BigDecimal amount) {}