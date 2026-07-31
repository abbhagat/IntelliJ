package lld.apigateway;

import lombok.Setter;
import java.util.List;

@Setter
public class LoadBalancer {

  private List<Service> userServiceList;
  private List<Service> orderServiceList;
  private static int i  = 0, j = 0;

  public Service getService(String serviceName) {
    Service service = null;
    switch (serviceName) {
      case "userService" -> {
        service = userServiceList.get(i);
        i = (i + 1) % userServiceList.size();
      }
      case "orderService" -> {
        service = orderServiceList.get(j);
        j = (j + 1) % orderServiceList.size();
      }
    }
    return service;
  }
}
