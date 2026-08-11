package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class ExpenseSplitFactory {

  private static final Map<ExpenseType, SplitStrategy> strategies = new HashMap<>();

  static {
    strategies.put(
        ExpenseType.EQUAL,
        new EqualSplit());

    strategies.put(
        ExpenseType.EXACT,
        new ExactSplit());

    strategies.put(
        ExpenseType.PERCENT,
        new PercentSplit());
  }

  public static SplitStrategy getStrategy(ExpenseType type) {
    SplitStrategy strategy = strategies.get(type);
    if (strategy == null) {
      throw new RuntimeException("Unsupported expense type: " + type);
    }
    return strategy;
  }
}