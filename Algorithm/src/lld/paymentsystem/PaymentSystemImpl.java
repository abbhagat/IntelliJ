package lld.paymentsystem;

import java.util.Map;

public class PaymentSystemImpl {

  public static void main(String[] args) {
    Request request = new Request("TXN123", 500,PaymentMethod.UPI, Map.of("upiId", "abc@upi"));
    Response response = new PaymentGateway().handleRequest(request);
    System.out.println(response);
  }
}
