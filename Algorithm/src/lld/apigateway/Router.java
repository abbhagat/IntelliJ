package lld.apigateway;

import java.util.Map;

public record Router(Map<String, String> routes) {

  public void registerRoute(String path, String serviceName) {
    routes.put(path, serviceName);
  }

  public String getServiceName(String path) {
    return routes.get(path);
  }
}
