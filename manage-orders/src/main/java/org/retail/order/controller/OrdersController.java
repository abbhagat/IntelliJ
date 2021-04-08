package org.retail.order.controller;

import org.retail.order.model.Orders;
import org.retail.order.service.OrderItemsService;
import org.retail.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService service;

    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping(value = "/getAllOrders")
    public List<Orders> getAllOrders() {
        return service.getAllOrders();
    }

    @PostMapping(value = "/saveOrders")
    @ResponseStatus(HttpStatus.OK)
    public void saveOrders(@RequestBody Orders orders) {
        service.saveOrders(orders);
    }
}
