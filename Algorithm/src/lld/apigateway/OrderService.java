package lld.apigateway;

class OrderService implements Service {

  @Override
  public Response handleRequest(Request request) {
    return new Response(200, "Order Service Response");
  }
}
