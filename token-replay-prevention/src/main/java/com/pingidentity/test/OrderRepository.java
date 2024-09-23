package com.pingidentity.test;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final Map<UUID, Order> orderMap = new HashMap<>();

    public Order save(Order order) {
        UUID orderId = UUID.randomUUID();
        order.setId(orderId);
        orderMap.put(UUID.randomUUID(), order);
        System.out.println(orderMap);
        return order;
    }
}
