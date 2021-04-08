package org.retail.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.retail.order.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrdersInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "saveFallbackOrders",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "50000")
            }
    )
    public void saveSupplier(HttpEntity<Supplier> httpEntity) {
        restTemplate.postForObject("http://manage-supplier/supplier/saveSupplier", httpEntity, Supplier.class);
    }

    public void saveFallbackOrders(HttpEntity<Supplier> httpEntity) {
        System.out.println("No Orders to save");
    }
}
