package lld.apigateway;

import java.util.List;
import java.util.Map;

/**
 * "API Gateway is a centralized entry point that handles authentication, rate limiting, routing, and load balancing.
 * Internally, it consists of a Router, AuthManager, RateLimiter, and LoadBalancer.
 * It forwards validated requests to microservices and returns aggregated responses."
 *
 */
public class ApiGatewayImpl {

  public static void main(String[] args) {

    Router router = new Router();
    AuthenticationManager authManager = new AuthenticationManager();
    RateLimiter rateLimiter = new RateLimiter();
    Service userService  = new UserService();
    Service orderService = new UserService();
    LoadBalancer loadBalancer = new LoadBalancer(List.of(userService, orderService));
    router.registerRoute("/user", userService);
    router.registerRoute("/order", orderService);
    ApiGateway apiGateway = new ApiGateway(router, authManager, rateLimiter, loadBalancer);
    Request request = new Request();
    request.setHeaders(Map.of("Authorization", "valid-token", "clientId", "abhinawb"));
    request.setPath("/user");
    Response response = apiGateway.handleRequest(request);
    System.out.println(response);
  }
}
