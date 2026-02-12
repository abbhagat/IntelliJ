package lld.apigateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiGateway {

  private final Router router;
  private final AuthenticationManager authManager;
  private final RateLimiter rateLimiter;

  public void handleRequest(Request request) {
    // Step 1: Authenticate
    if (!authManager.authenticate(request)) {
      new Response(401, "Unauthorized");
      return;
    }
    // Step 2: Rate limit
    String clientId = request.getHeaders().get("client-id");
    if (!rateLimiter.allowRequest(clientId)) {
      new Response(429, "Too Many Requests");
      return;
    }
    // Step 3: Route
    Service service = router.getService(request.getPath());
    if (service == null) {
      new Response(404, "Not Found");
      return;
    }
    // Step 4: Forward request
    service.handle(request);
  }
}
