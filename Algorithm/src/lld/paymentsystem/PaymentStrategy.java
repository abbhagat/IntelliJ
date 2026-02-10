package lld.paymentsystem;

public interface PaymentStrategy {
  PaymentResponse pay(PaymentRequest request);
}
