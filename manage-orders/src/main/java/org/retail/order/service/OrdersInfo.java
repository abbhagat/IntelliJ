package org.retail.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.retail.order.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Fallback is used to:
 *  1. Return default response
 *  2. Log error
 *  3. Store data temporarily
 *  4. Avoid crashing system
 *
 */


@Service
public class OrdersInfo {

  @Autowired
  private RestTemplate restTemplate;

  @HystrixCommand(
      fallbackMethod = "saveFallbackOrders",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"), // If manage-supplier does not respond within 5 seconds Call is aborted and Fallback method is triggered
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),          // Minimum 5 requests must occur before circuit breaker evaluates errors.
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),      // If 50% of requests fail, circuit opens.
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "50000")  // Circuit stays OPEN for 50 seconds. No real calls are made, All requests go directly to fallback After 50 seconds: Hystrix allows 1 test request (Half-Open state) If success → circuit closes If fail → circuit opens again
      },
      threadPoolKey = "ordersInfoThreadPoolKey",
      threadPoolProperties = {
          @HystrixProperty(name = "coreSize", value = "20"),
          @HystrixProperty(name = "maxQueueSize", value = "10"),
      }
  )
  public void saveSupplier(HttpEntity<Supplier> httpEntity) {
    restTemplate.postForObject("http://manage-supplier/supplier/saveSupplier", httpEntity, Supplier.class); // calls another microservice If it fails or is slow → fallback method is triggered
  }

  public void saveFallbackOrders(HttpEntity<Supplier> httpEntity) {
    System.out.println("No Orders to save");
  }
}
