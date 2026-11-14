package com.kafka.streams.order.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.streams.order.model.Order;
import com.kafka.streams.order.model.OrderType;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import static com.kafka.streams.order.Util.buildOrders;
import static com.kafka.streams.order.Util.objectMapper;
import static com.kafka.streams.order.launcher.TopicUtil.ORDERS;
import static com.kafka.streams.order.producer.ProducerUtil.publishMessageSync;
import static java.lang.Thread.sleep;

@Slf4j
public class OrdersMockDataProducer {

  public static void main(String[] args) throws InterruptedException {
    List<Order> orders = buildOrders();
    publishOrders(orders);
    publishBulkOrders();
    publishOrdersForGracePeriod(orders);
    publishFutureRecords();
    publishExpiredRecords();
  }

  private static void publishFutureRecords() {
    var localDateTime = LocalDateTime.now().plusDays(1);
    var newOrders = buildOrders()
        .stream()
        .map(order ->
            new Order(order.orderId(),
                order.locationId(),
                order.totalAmount(),
                order.orderType(),
                order.orderLineItems(),
                localDateTime))
        .toList();
    publishOrders(newOrders);
  }

  private static void publishExpiredRecords() {
    var localDateTime = LocalDateTime.now().minusDays(1);
    var newOrders = buildOrders()
        .stream()
        .map(order ->
            new Order(order.orderId(),
                order.locationId(),
                order.totalAmount(),
                order.orderType(),
                order.orderLineItems(),
                localDateTime))
        .toList();
    publishOrders(newOrders);

  }

  private static void publishOrdersForGracePeriod(List<Order> orders) {
    var localTime = LocalDateTime.now().toLocalTime();
    var modifiedTime = LocalTime.of(localTime.getHour(), localTime.getMinute(), 18);
    var localDateTime = LocalDateTime.now().with(modifiedTime);

    //With Grace Period
    //[general_orders_revenue_window]: , TotalRevenue[locationId=store_4567, runnuingOrderCount=1, runningRevenue=27.00]
    //[general_orders_revenue_window]: TotalRevenue[locationId=store_1234, runnuingOrderCount=1, runningRevenue=27.00]
    //[general_orders_revenue_window]:  TotalRevenue[locationId=store_4567, runnuingOrderCount=1, runningRevenue=27.00]
    //[general_orders_revenue_window]:  TotalRevenue[locationId=store_4567, runnuingOrderCount=1, runningRevenue=27.00]

    //Without Grace Period
    //[general_orders_revenue_window]: , TotalRevenue[locationId=store_4567, runnuingOrderCount=1, runningRevenue=27.00]
    //[general_orders_revenue_window]: TotalRevenue[locationId=store_1234, runnuingOrderCount=1, runningRevenue=27.00]
    //[general_orders_revenue_window]:  TotalRevenue[locationId=store_4567, runnuingOrderCount=1, runningRevenue=27.00]
    //[general_orders_revenue_window]:  TotalRevenue[locationId=store_4567, runnuingOrderCount=1, runningRevenue=27.00]

    var generalOrdersWithCustomTime = orders
        .stream()
        .filter(order -> order.orderType().equals(OrderType.GENERAL))
        .map(order ->
            new Order(order.orderId(),
                order.locationId(),
                order.totalAmount(),
                order.orderType(),
                order.orderLineItems(),
                localDateTime))
        .toList();

    var generalOrders = orders
        .stream()
        .filter(order -> order.orderType().equals(OrderType.GENERAL))
        .toList();
    publishOrders(generalOrders);
    //orders with the timestamp as 18th second
    publishRecordsWithDelay(generalOrdersWithCustomTime, localDateTime, 18);
  }

  private static void publishRecordsWithDelay(List<Order> newOrders, LocalDateTime localDateTime) {
    publishOrders(newOrders);
  }

  private static void publishRecordsWithDelay(List<Order> newOrders, LocalDateTime localDateTime, int timeToPublish) {
    var flag = true;
    while (flag) {
      var dateTime = LocalDateTime.now();
      if (dateTime.toLocalTime().getMinute() == localDateTime.getMinute()
          && dateTime.toLocalTime().getSecond() == timeToPublish) {
        System.out.print("Publishing the record with delay ");
        publishOrders(newOrders);
        flag = false;
      } else {
        System.out.println(" Current Time is  and the record will be published at the 16th second: " + dateTime);
        System.out.println("Record Date Time : " + localDateTime);
      }
    }
  }

  private static void publishBulkOrders() throws InterruptedException {
    int count = 0;
    while (count < 100) {
      var orders = buildOrders();
      publishOrders(orders);
      sleep(1000);
      count++;
    }
  }

  private static void publishOrders(List<Order> orders) {
    orders
        .forEach(order -> {
          try {
            var ordersJSON = objectMapper.writeValueAsString(order);
            var recordMetaData = publishMessageSync(ORDERS, order.orderId() + "", ordersJSON);
            log.info("Published the order message : {} ", recordMetaData);
          } catch (JsonProcessingException e) {
            log.error("JsonProcessingException : {} ", e.getMessage(), e);
            throw new RuntimeException(e);
          } catch (Exception e) {
            log.error("Exception : {} ", e.getMessage(), e);
            throw new RuntimeException(e);
          }
        });
  }
}
