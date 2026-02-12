package lld.apigateway;

/**
 * "API Gateway is a centralized entry point that handles authentication, rate limiting, routing, and load balancing.
 * Internally, it consists of a Router, AuthManager, RateLimiter, and LoadBalancer.
 * It forwards validated requests to microservices and returns aggregated responses."
 *
 */
public class ApiGatewayImpl {

  public static void main(String[] args) {
    ApiGateway apiGateway = null;
    Request request = new Request();
    Response response = apiGateway.handleRequest(request);
    System.out.println(response);
  }
}
