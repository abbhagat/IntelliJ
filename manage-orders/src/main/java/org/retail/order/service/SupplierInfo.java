package org.retail.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.retail.order.model.OrderItems;
import org.retail.order.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SupplierInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getFallbackSupplier",
            commandProperties = {
                         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
                         @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                         @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                         @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "50000")
            }
    )
    public Supplier getSupplier(OrderItems orderItems) {
        return restTemplate.getForObject("http://manage-supplier/supplier/getSupplierByID/" + orderItems.getSupplierID(), Supplier.class);
    }

    public Supplier getFallbackSupplier(OrderItems orderItems) {
        return new Supplier();
    }
}
