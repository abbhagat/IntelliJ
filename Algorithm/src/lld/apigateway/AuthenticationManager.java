package lld.apigateway;

public class AuthenticationManager {

  public boolean authenticate(Request request) {
    String token = request.getHeaders().get("Authorization");
    return token != null && token.equals("valid-token");
  }
}
