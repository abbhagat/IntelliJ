package lld.paymentsystem;

public class UPIPaymentStrategy implements PaymentStrategy {

  public PaymentResponse pay(PaymentRequest request) {
    String upiId = request.getPaymentDetails().get("upiId");
    System.out.println("Processing UPI payment for " + upiId);
    return new PaymentResponse(true, "UPI Payment Successful");
  }
}

