package com.kafka.streams.order.domain;

import java.math.BigDecimal;

public record OrderLineItem(String item, Integer count, BigDecimal amount) {
}