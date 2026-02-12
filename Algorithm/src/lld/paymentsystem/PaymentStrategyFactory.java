package lld.paymentsystem;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {

  private static final Map<PaymentMethod, PaymentStrategy> paymentStrategy = new HashMap<>();

  static {
    paymentStrategy.put(PaymentMethod.UPI, new UPIPaymentStrategy());
    paymentStrategy.put(PaymentMethod.BANK_TRANSFER, new BankTransferPaymentStrategy());
    paymentStrategy.put(PaymentMethod.WALLET, new WalletPaymentStrategy());
    paymentStrategy.put(PaymentMethod.CARD, new CardPaymentStrategy());
  }

  static PaymentStrategy getStrategy(PaymentMethod paymentMethod) {
    if (!paymentStrategy.containsKey(paymentMethod)) {
      throw new IllegalArgumentException("Unsupported payment method");
    }
    return paymentStrategy.get(paymentMethod);
  }
}
