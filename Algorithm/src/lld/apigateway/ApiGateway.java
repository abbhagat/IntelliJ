package lld.apigateway;

public class ApiGateway {

  private final Router router;
  private final AuthenticationManager authManager;
  private final RateLimiter rateLimiter;

  public ApiGateway(Router router, AuthenticationManager authManager, RateLimiter rateLimiter) {
    this.router = router;
    this.authManager = authManager;
    this.rateLimiter = rateLimiter;
  }

  public Response handleRequest(Request request) {
    // Step 1: Authenticate
    if (!authManager.authenticate(request)) {
      return new Response(401, "Unauthorized");
    }
    // Step 2: Rate limit
    String clientId = request.headers.get("client-id");
    if (!rateLimiter.allowRequest(clientId)) {
      return new Response(429, "Too Many Requests");
    }
    // Step 3: Route
    Service service = router.getService(request.path);
    if (service == null) {
      return new Response(404, "Not Found");
    }
    // Step 4: Forward request
    return service.handle(request);
  }
}
