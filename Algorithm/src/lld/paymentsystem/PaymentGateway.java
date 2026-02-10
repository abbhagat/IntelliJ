package lld.paymentsystem;

public class PaymentGateway {

  public PaymentResponse processPayment(PaymentRequest request) {
    PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(request.getPaymentMethod());
    return strategy.pay(request);
  }
}
