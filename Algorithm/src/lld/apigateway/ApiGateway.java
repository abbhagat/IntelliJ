package lld.apigateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiGateway {

  private final Router router;
  private final AuthenticationManager authManager;
  private final RateLimiter rateLimiter;

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
    Service service = router.getService(request.getPath());
    if (service == null) {
      return new Response(404, "Not Found");
    }
    // Step 4: Forward request
    return service.handle(request);
  }
}
