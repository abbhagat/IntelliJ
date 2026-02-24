package lld.apigateway;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response {
  private int statusCode;
  private String responseBody;
}

