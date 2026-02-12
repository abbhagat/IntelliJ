package lld.apigateway;

public class ApiGatewayImpl {

  public static void main(String[] args) {
    ApiGateway apiGateway = null;
    Request request = new Request();
    apiGateway.handleRequest(request);
  }
}
