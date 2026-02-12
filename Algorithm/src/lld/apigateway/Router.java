package lld.apigateway;

import java.util.HashMap;
import java.util.Map;

public class Router {
  private final Map<String, Service> routes = new HashMap<>();

  public void registerRoute(String path, Service service) {
    routes.put(path, service);
  }

  public Service getService(String path) {
    return routes.get(path);
  }
}
