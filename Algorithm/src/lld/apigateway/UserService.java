package lld.apigateway;

public class UserService implements Service {

  public Response handle(Request request) {
    return new Response(200, "User Service Response");
  }
}

