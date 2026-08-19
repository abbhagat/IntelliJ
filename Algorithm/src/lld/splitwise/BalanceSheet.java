package lld.splitwise;

import java.util.Map;

public record BalanceSheet(Map<String, Map<String, Double>> balanceSheet) {}
