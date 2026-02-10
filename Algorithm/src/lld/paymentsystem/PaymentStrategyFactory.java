package lld.paymentsystem;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {

  private static final Map<PaymentMethod, PaymentStrategy> strategies = new HashMap<>();

  static {
    strategies.put(PaymentMethod.UPI, new UPIPaymentStrategy());
    strategies.put(PaymentMethod.BANK_TRANSFER, new BankTransferPaymentStrategy());
    strategies.put(PaymentMethod.WALLET, new WalletPaymentStrategy());
  }

  static PaymentStrategy getStrategy(PaymentMethod method) {
    if (!strategies.containsKey(method)) {
      throw new IllegalArgumentException("Unsupported payment method");
    }
    return strategies.get(method);
  }
}
