package lld.apigateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiGateway {

  private final AuthenticationManager authManager;
  private final RateLimiter rateLimiter;
  private final Router router;
  private final LoadBalancer loadBalancer;

  public Response handleRequest(Request request) {
    // Step 1: Authenticate
    if (!authManager.authenticate(request)) {
      return new Response(401, "Unauthorized");
    }
    // Step 2: Rate limit
    String clientId = request.getHeaders().get("client-id");
    if (!rateLimiter.allowRequest(clientId)) {
      return new Response(429, "Too Many Requests");
    }
    // Step 3: Route
    String serviceName = router.getServiceName(request.getPath());
    if (serviceName == null) {
      return new Response(404, "Not Found");
    }
    // Step 4: Load Balance
    Service service = loadBalancer.getInstance(serviceName);
    // Step 5: Forward request
    return service.handleRequest(request);
  }
}
