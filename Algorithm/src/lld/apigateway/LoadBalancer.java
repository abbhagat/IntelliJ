package lld.apigateway;

import java.util.List;

public class LoadBalancer {

  private final List<Service> userServiceList;
  private final List<Service> orderServiceList;
  private int userServiceIndex = 0;
  private int orderServiceIndex = 0;

  public LoadBalancer(List<Service> userServiceList, List<Service> orderServiceList) {
    this.userServiceList = userServiceList;
    this.orderServiceList = orderServiceList;
  }

  public Service getInstance(String serviceName) {
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
