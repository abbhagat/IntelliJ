package lld.paymentsystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

  private String transactionId;
  private double amount;
  private PaymentMethod paymentMethod;
  private Map<String, String> paymentDetails;
}
