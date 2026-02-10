package lld.paymentsystem;

import java.util.Map;

public class PaymentSystemImpl {

  public static void main(String[] args) {
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setTransactionId("TXN123");
    paymentRequest.setAmount(500);
    paymentRequest.setPaymentMethod(PaymentMethod.UPI);
    paymentRequest.setPaymentDetails(Map.of("upiId", "abc@upi"));
    PaymentGateway gateway = new PaymentGateway();
    PaymentResponse response = gateway.processPayment(paymentRequest);
    System.out.println(response);
  }
}
