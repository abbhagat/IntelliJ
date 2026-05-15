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
    AuthenticationManager authManager = new AuthenticationManager();
    RateLimiter rateLimiter = new RateLimiter();
    Router router = new Router();
    LoadBalancer loadBalancer = new LoadBalancer();

    Service userService1  = new UserService();
    Service userService2  = new UserService();
    Service orderService1 = new OrderService();
    Service orderService2 = new OrderService();
    loadBalancer.setUserServiceList(List.of(userService1, userService2));
    loadBalancer.setOrderServiceList(List.of(orderService1, orderService2));

    router.registerRoute("/user", "userService");
    router.registerRoute("/order", "orderService");

    ApiGateway apiGateway = new ApiGateway(authManager, rateLimiter, router, loadBalancer);

    Request request = new Request();
    request.setPath("/user");
    request.setMethod("GET");
    request.setHeaders(Map.of("Authorization", "valid-token", "clientId", "abhinawb"));
    request.setRequestBody("Request Body");

    Response response = apiGateway.handleRequest(request);
    System.out.println(response);
  }
}
