package lld.paymentsystem;

public class PaymentGateway {

  public Response handleRequest(Request request) {
    PaymentMethod paymentMethod = request.getPaymentMethod();
    PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStrategy(paymentMethod);
    return paymentStrategy.handleRequest(request);
  }
}
