package lld.paymentsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentResponse {
  private boolean success;
  private String message;
}
