package lld.paymentsystem;

public class PaymentGateway {

  public PaymentResponse processPayment(PaymentRequest request) {
    PaymentStrategy strategy =
        PaymentStrategyFactory.getStrategy(request.method);

    return strategy.pay(request);
  }
}
