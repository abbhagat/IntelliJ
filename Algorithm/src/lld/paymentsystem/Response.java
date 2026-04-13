package lld.paymentsystem;

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
