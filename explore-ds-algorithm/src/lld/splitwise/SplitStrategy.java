package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class SplitStrategy {

  private static final Map<ExpenseType, Split> splitStrategyMap = new HashMap<>();

  static {
    splitStrategyMap.put(ExpenseType.EXACT,   new ExactSplit());
    splitStrategyMap.put(ExpenseType.EQUAL,   new EqualSplit());
    splitStrategyMap.put(ExpenseType.PERCENT, new PercentSplit());
  }

  public static Split getStrategy(ExpenseType expenseType) {
    return splitStrategyMap.get(expenseType);
  }
}
