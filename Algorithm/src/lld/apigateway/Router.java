package lld.apigateway;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Router {

  private final Map<String, String> routes;

  public void registerRoute(String path, String serviceName) {
    routes.put(path, serviceName);
  }

  public String getServiceName(String path) {
    return routes.get(path);
  }
}
