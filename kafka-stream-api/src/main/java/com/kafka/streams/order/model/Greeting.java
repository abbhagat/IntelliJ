package com.kafka.streams.order.model;

import java.time.LocalDateTime;

public record Greeting(String message, LocalDateTime timestamp) {}
