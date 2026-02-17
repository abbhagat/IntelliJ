package lld.apigateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
  private String path;
  private String method;
  private Map<String, String> headers;
  private String requestBody;
}
