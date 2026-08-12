package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class SplitStrategy {

  private static final Map<ExpenseType, Split> splitMap = new HashMap<>();

  static {
    splitMap.put(ExpenseType.EXACT,   new ExactSplit());
    splitMap.put(ExpenseType.EQUAL,   new EqualSplit());
    splitMap.put(ExpenseType.PERCENT, new PercentSplit());
  }

  public static Split getStrategy(ExpenseType expenseType) {
    return splitMap.get(expenseType);
  }
}