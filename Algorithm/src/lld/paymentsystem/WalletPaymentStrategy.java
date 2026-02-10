package lld.paymentsystem;

public class WalletPaymentStrategy implements PaymentStrategy {

  public PaymentResponse pay(PaymentRequest request) {
    String walletId = request.paymentDetails.get("walletId");

    System.out.println("Processing Wallet payment for " + walletId);

    return new PaymentResponse(true, "Wallet Payment Successful");
  }
}

