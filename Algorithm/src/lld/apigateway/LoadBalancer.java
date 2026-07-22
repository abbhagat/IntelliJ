package lld.apigateway;

import lombok.Setter;

import java.util.List;

public class LoadBalancer {

  @Setter
  private List<Service> userServiceList;
  @Setter
  private List<Service> orderServiceList;

  private int userServiceIndex  = 0;
  private int orderServiceIndex = 0;

  public Service getService(String serviceName) {
    Service service = null;
    switch (serviceName) {
      case "userService" -> {
        service = userServiceList.get(userServiceIndex);
        userServiceIndex = (userServiceIndex + 1) % userServiceList.size();
      }
      case "orderService" -> {
        service = orderServiceList.get(orderServiceIndex);
        orderServiceIndex = (orderServiceIndex + 1) % orderServiceList.size();
      }
    }
    return service;
  }
}
