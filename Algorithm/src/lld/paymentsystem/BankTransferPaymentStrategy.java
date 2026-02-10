package lld.paymentsystem;

public class BankTransferPaymentStrategy implements PaymentStrategy {

  public PaymentResponse pay(PaymentRequest request) {
    String account = request.paymentDetails.get("accountNumber");
    String ifsc = request.paymentDetails.get("ifsc");

    System.out.println("Processing Bank Transfer to " + account);

    return new PaymentResponse(true, "Bank Transfer Successful");
  }
}

