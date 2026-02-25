package lld.paymentsystem;

public interface PaymentStrategy {
  Response handleRequest(Request request);
}
