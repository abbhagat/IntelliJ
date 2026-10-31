package com.kafka.streams.order.domain;

public record Address(String addressLine1,
                      String addressLine2,
                      String city,
                      String state,
                      String zip) {
}