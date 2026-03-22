package lld.paymentsystem;

public class WalletPaymentStrategy implements PaymentStrategy {

  public Response handleRequest(Request request) {
    String walletId = request.getPaymentDetails().get("walletId");
    System.out.println("Processing Wallet payment for " + walletId);
    return new Response(200, "Wallet Payment Successful");
  }
}
