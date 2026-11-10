package com.kafka.streams.app.model;

import java.time.LocalDateTime;

public record Greeting(String message, LocalDateTime timeStamp) {

  @Override
  public String toString() {
    return "Greeting { " + "message='" + message + '\'' + ", timeStamp=" + timeStamp + '}';
  }
}
