package lld.paymentsystem;

public class PaymentGateway {

  public PaymentResponse processPayment(PaymentRequest request) {
    PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStrategy(request.getPaymentMethod());
    return paymentStrategy.pay(request);
  }
}
