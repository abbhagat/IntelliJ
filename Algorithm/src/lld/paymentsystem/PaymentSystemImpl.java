package lld.paymentsystem;

import java.util.Map;

public class PaymentSystemImpl {

  public static void main(String[] args) {
    PaymentRequest request = new PaymentRequest();
    request.transactionId = "TXN123";
    request.amount = 500;
    request.method = PaymentMethod.UPI;
    request.paymentDetails = Map.of("upiId", "abc@upi");
    PaymentGateway gateway = new PaymentGateway();
    PaymentResponse response = gateway.processPayment(request);
    System.out.println(response);
  }
}
