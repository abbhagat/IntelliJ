package lld.paymentsystem;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {

  private static final Map<PaymentMethod, PaymentStrategy> paymentStrategyMap = new HashMap<>();

  static {
    paymentStrategyMap.put(PaymentMethod.UPI, new UPIPaymentStrategy());
    paymentStrategyMap.put(PaymentMethod.BANK_TRANSFER, new BankTransferPaymentStrategy());
    paymentStrategyMap.put(PaymentMethod.WALLET, new WalletPaymentStrategy());
    paymentStrategyMap.put(PaymentMethod.CARD, new CardPaymentStrategy());
  }

  static PaymentStrategy getStrategy(PaymentMethod paymentMethod) {
    if (!paymentStrategyMap.containsKey(paymentMethod)) {
      throw new IllegalArgumentException("Unsupported payment method");
    }
    return paymentStrategyMap.get(paymentMethod);
  }
}
