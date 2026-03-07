package lld.paymentsystem;

import java.util.Map;

public class PaymentSystemImpl {

  public static void main(String[] args) {
    Request request = new Request("TXN123", 500,PaymentMethod.UPI, Map.of("upiId", "abc@upi"));
    PaymentGateway paymentGateway = new PaymentGateway();
    Response response = paymentGateway.handleRequest(request);
    System.out.println(response);
  }
}
