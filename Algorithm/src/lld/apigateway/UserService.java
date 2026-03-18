package lld.apigateway;

public class UserService implements Service {

  @Override
  public Response handleRequest(Request request) {
    return new Response(200, "User Service Response");
  }
}
