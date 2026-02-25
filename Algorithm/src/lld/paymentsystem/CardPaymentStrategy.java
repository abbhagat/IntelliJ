package lld.paymentsystem;

public class CardPaymentStrategy implements PaymentStrategy {

  public Response handleRequest(Request request) {
    String cardId = request.getPaymentDetails().get("cardId");
    System.out.println("Processing Card payment for " + cardId);
    return new Response(true, "Card Payment Successful");
  }
}
