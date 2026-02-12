package lld.apigateway;

import java.util.List;

public class LoadBalancer {

  private final List<Service> instances;
  private int index = 0;

  public LoadBalancer(List<Service> instances) {
    this.instances = instances;
  }

  public Service getInstance() {
    Service service = instances.get(index);
    index = (index + 1) % instances.size();
    return service;
  }
}
