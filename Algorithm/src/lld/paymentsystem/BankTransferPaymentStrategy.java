package lld.paymentsystem;

public class BankTransferPaymentStrategy implements PaymentStrategy {

  public PaymentResponse pay(PaymentRequest request) {
    String account = request.getPaymentDetails().get("accountNumber");
    String ifsc = request.getPaymentDetails().get("ifsc");
    System.out.println("Processing Bank Transfer to " + account);
    return new PaymentResponse(true, "Bank Transfer Successful");
  }
}
