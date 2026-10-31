package com.kafka.streams.order.domain;

import java.time.LocalDateTime;

public record Greeting(String message, LocalDateTime timestamp) {
}
