package org.retail.order.repository;

import org.retail.order.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {

    @Query(value = "from OrderItems where orderID = :orderID")
    List<OrderItems> findByOrderID(Long orderID);
}
