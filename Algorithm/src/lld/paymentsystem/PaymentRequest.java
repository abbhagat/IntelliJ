package lld.paymentsystem;

import java.util.Map;

public class PaymentRequest {
  String transactionId;
  double amount;
  PaymentMethod method;
  Map<String, String> paymentDetails;
}
