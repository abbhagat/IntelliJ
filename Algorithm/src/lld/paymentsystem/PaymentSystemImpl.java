package lld.paymentsystem;

import java.util.Map;

public class PaymentSystemImpl {

  public static void main(String[] args) {
    PaymentRequest request = new PaymentRequest();
    request.setTransactionId("TXN123");
    request.setAmount(500);
    request.setPaymentMethod(PaymentMethod.UPI);
    request.setPaymentDetails(Map.of("upiId", "abc@upi"));
    PaymentGateway gateway = new PaymentGateway();
    PaymentResponse response = gateway.processPayment(request);
    System.out.println(response);
  }
}
