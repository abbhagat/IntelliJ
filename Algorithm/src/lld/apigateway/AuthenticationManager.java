package lld.apigateway;

public class AuthenticationManager {

  public boolean authenticate(Request request) {
    String token = request.headers.get("Authorization");
    return token != null && token.equals("valid-token");
  }
}
