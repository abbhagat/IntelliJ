package lld.paymentsystem;

public class CardPaymentStrategy implements PaymentStrategy {

  public PaymentResponse pay(PaymentRequest request) {
    String cardId = request.getPaymentDetails().get("cardId");
    System.out.println("Processing Card payment for " + cardId);
    return new PaymentResponse(true, "Card Payment Successful");
  }
}
