package lld.paymentsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response {

  private boolean success;
  private String message;

}
