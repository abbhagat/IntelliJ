package lld.apigateway;

class OrderService implements Service {

  public Response handleRequest(Request request) {
    return new Response(200, "Order Service Response");
  }
}
