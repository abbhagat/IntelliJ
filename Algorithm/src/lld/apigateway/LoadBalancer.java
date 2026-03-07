package lld.apigateway;

import java.util.List;

public class LoadBalancer {

  private final List<Service> serviceList;
  private int index = 0;

  public LoadBalancer(List<Service> serviceList) {
    this.serviceList = serviceList;
  }

  public Service getInstance() {
    Service service = serviceList.get(index);
    index = (index + 1) % serviceList.size();
    return service;
  }
}
