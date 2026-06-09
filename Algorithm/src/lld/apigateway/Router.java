package lld.apigateway;

import java.util.HashMap;
import java.util.Map;

public class Router {

  private final Map<String, String> routes;

  public Router() {
    routes = new HashMap<>();
  }

  public void registerRoute(String path, String serviceName) {
    routes.put(path, serviceName);
  }

  public String getServiceName(String path) {
    return routes.get(path);
  }
}
