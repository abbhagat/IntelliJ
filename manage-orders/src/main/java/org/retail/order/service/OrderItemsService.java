package org.retail.order.service;

import org.retail.order.model.OrderItems;
import org.retail.order.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsDAO;

    public List<OrderItems> getAllOrderItemsByID(Long orderID) {
        return orderItemsDAO.findByOrderID(orderID);
    }

    public List<OrderItems> getAllOrderItems() {
        return orderItemsDAO.findAll();
    }

    public void saveOrderItems(OrderItems orderItems) {
        orderItemsDAO.save(orderItems);
    }
}
