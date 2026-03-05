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

  Hystrix Circuit Breaker has 3 states:- CLOSED, OPEN, HALF-OPEN
   State	        Meaning
   CLOSED	      Normal operation
   OPEN	        Calls blocked, fallback only
   HALF-OPEN	  Testing if service recovered
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
      threadPoolKey = "ordersInfoThreadPoolKey",  // Hystrix runs this call in a separate thread pool to prevent slow service from blocking main application threads.
      threadPoolProperties = {
          @HystrixProperty(name = "coreSize", value = "20"), // Maximum 20 threads can execute simultaneously.
          @HystrixProperty(name = "maxQueueSize", value = "10"), // If all 20 threads busy: 10 more requests can wait in queue After that all requests are rejected
      }
  )
  public void saveSupplier(HttpEntity<Supplier> httpEntity) {
    restTemplate.postForObject("http://manage-supplier/supplier/saveSupplier", httpEntity, Supplier.class); // calls another microservice If it fails or is slow → fallback method is triggered
  }

  public void saveFallbackOrders(HttpEntity<Supplier> httpEntity) {
    System.out.println("No Orders to save" + httpEntity.toString());
  }
}
