package com.pingidentity.test;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class OrderServiceTest {

    @Spy
    OrderRepository orderRepository;
    @Spy
    NotificationService notificationService;
    @InjectMocks
    OrderService orderService;

    @Test
    public void givenNotificationServiceIsUsingSpy_whenOrderServiceIsCalled_thenNotificationServiceSpyShouldBeInvoked() {
        UUID orderId = UUID.randomUUID();
        Order orderInput = new Order(orderId, "Test", 1, "17 St Andrews Croft, Leeds ,LS17 7TP");
        doReturn(orderInput).when(orderRepository).save(any());
        doReturn(true).when(notificationService).raiseAlert(any(Order.class));
        Order order = orderService.save(orderInput);
        assertNotNull(order);
        assertEquals(orderId, order.getId());
        verify(notificationService).notify(any(Order.class));
    }
}
