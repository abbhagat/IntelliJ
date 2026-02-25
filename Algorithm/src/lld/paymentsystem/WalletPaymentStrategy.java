package lld.paymentsystem;

public class WalletPaymentStrategy implements PaymentStrategy {

  public Response handleRequest(Request request) {
    String walletId = request.getPaymentDetails().get("walletId");
    System.out.println("Processing Wallet payment for " + walletId);
    return new Response(true, "Wallet Payment Successful");
  }
}
