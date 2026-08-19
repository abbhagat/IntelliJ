package lld.paymentsystem;

import java.util.HashMap;
import java.util.Map;
import static lld.paymentsystem.PaymentMethod.*;

public class PaymentStrategyFactory {

  private static final Map<PaymentMethod, PaymentStrategy> paymentStrategyMap = new HashMap<>();

  static {
    paymentStrategyMap.put(UPI, new UPIPaymentStrategy());
    paymentStrategyMap.put(BANK_TRANSFER, new BankTransferPaymentStrategy());
    paymentStrategyMap.put(WALLET, new WalletPaymentStrategy());
    paymentStrategyMap.put(CARD, new CardPaymentStrategy());
  }

  public static PaymentStrategy getStrategy(PaymentMethod paymentMethod) {
    if (!paymentStrategyMap.containsKey(paymentMethod)) {
      throw new IllegalArgumentException("Unsupported payment method");
    }
    return paymentStrategyMap.get(paymentMethod);
  }
}
