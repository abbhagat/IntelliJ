package lld.paymentsystem;

import java.util.Map;

public record Request(String transId, double amount, PaymentMethod paymentMethod, Map<String, String> paymentDetails) {}
