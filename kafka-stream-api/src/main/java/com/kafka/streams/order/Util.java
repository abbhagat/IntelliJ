package com.kafka.streams.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kafka.streams.order.model.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

public class Util {

  private Util() {
    // private constructor to prevent instantiation
  }

  public static final Properties config = new Properties();
  public static final String BROKER_LIST = "localhost:9092,localhost:9094,localhost:9096";
  public static final String LATEST = "latest";

  public static ObjectMapper objectMapper = new ObjectMapper()
      .registerModule(new JavaTimeModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

  public static List<Store> getStoresList() {
    Address address1 = new Address("1234 Street 1 ", "", "City1", "State1", "12345");
    Store store1     = new Store("store_1234", address1, "1234567890");
    Address address2 = new Address("1234 Street 2 ", "", "City2", "State2", "541321");
    Store store2     = new Store("store_4567", address2, "0987654321");
    return List.of(store1, store2);
  }

  public static List<Order> buildOrdersForGracePeriod() {

    var orderItems = List.of(
        new OrderLineItem("Bananas", 2, new BigDecimal("2.00")),
        new OrderLineItem("Iphone Charger", 1, new BigDecimal("25.00"))
    );

    var orderItemsRestaurant = List.of(
        new OrderLineItem("Pizza", 2, new BigDecimal("12.00")),
        new OrderLineItem("Coffee", 1, new BigDecimal("3.00"))
    );

    var order1 = new Order(12345, "store_999",
        new BigDecimal("27.00"),
        OrderType.RESTAURANT,
        orderItems,
        LocalDateTime.parse("2023-01-06T18:50:21")
    );

    var order2 = new Order(54321, "store_999",
        new BigDecimal("15.00"),
        OrderType.RESTAURANT,
        orderItemsRestaurant,
        LocalDateTime.parse("2023-01-06T18:50:21")
    );

    var order3 = new Order(54321, "store_999",
        new BigDecimal("15.00"),
        OrderType.RESTAURANT,
        orderItemsRestaurant,
        LocalDateTime.parse("2023-01-06T18:50:22")
    );

    return List.of(
        order1,
        order2,
        order3
    );

  }

  public static List<Order> buildOrders() {
    var orderItems = List.of(
        new OrderLineItem("Bananas", 2, new BigDecimal("2.00")),
        new OrderLineItem("Iphone Charger", 1, new BigDecimal("25.00"))
    );

    var orderItemsRestaurant = List.of(
        new OrderLineItem("Pizza", 2, new BigDecimal("12.00")),
        new OrderLineItem("Coffee", 1, new BigDecimal("3.00"))
    );

    var order1 = new Order(12345, "store_1234",
        new BigDecimal("27.00"),
        OrderType.GENERAL,
        orderItems,
        LocalDateTime.now()
        //LocalDateTime.now(ZoneId.of("UTC"))
    );

    var order2 = new Order(54321, "store_1234",
        new BigDecimal("15.00"),
        OrderType.RESTAURANT,
        orderItemsRestaurant,
        LocalDateTime.now()
        //LocalDateTime.now(ZoneId.of("UTC"))
    );

    var order3 = new Order(12345, "store_4567",
        new BigDecimal("27.00"),
        OrderType.GENERAL,
        orderItems,
        LocalDateTime.now()
        //LocalDateTime.now(ZoneId.of("UTC"))
    );

    var order4 = new Order(12345, "store_4567",
        new BigDecimal("27.00"),
        OrderType.RESTAURANT,
        orderItems,
        LocalDateTime.now()
        //LocalDateTime.now(ZoneId.of("UTC"))
    );

    return List.of(
        order1,
        order2,
        order3,
        order4
    );
  }
}
