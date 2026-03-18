package lld.apigateway;

import java.util.Set;

public class AuthenticationManager {

  private static final Set<String> validToken = Set.of("valid-token");

  public boolean authenticate(Request request) {
    String token = request.getHeaders().get("Authorization");
    return token != null && validToken.contains("valid-token");
  }
}
