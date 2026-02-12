package lld.paymentsystem;

import java.util.Map;

public class PaymentSystemImpl {

  public static void main(String[] args) {
    PaymentRequest paymentRequest   = new PaymentRequest("TXN123", 500,PaymentMethod.UPI, Map.of("upiId", "abc@upi"));
    PaymentResponse paymentResponse = new PaymentGateway().processPayment(paymentRequest);
    System.out.println(paymentResponse);
  }
}
