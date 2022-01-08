package org.retail.order.service;

import org.retail.order.model.Orders;
import org.retail.order.repository.OrdersRepository;
import org.retail.order.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersDAO;

    @Autowired
    private SupplierInfo supplierInfo;

    @Autowired
    private OrdersInfo ordersInfo;

    public List<Orders> getAllOrders() {
        return ordersDAO.findAll();
    }

    public void saveOrders(Orders orders) {
        orders.getOrderItems().forEach(orderItems -> {
            Optional<Supplier> optionalSupplier = Optional.ofNullable(supplierInfo.getSupplier(orderItems));
            Supplier supplier = null;
            if (optionalSupplier.isPresent()) {
                supplier = optionalSupplier.get();
                supplier.setQtyInStock(supplier.getQtyInStock() - orderItems.getQuantity());
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ordersInfo.saveSupplier(new HttpEntity<>(supplier, headers));
        });
        ordersDAO.save(orders);
    }
}
