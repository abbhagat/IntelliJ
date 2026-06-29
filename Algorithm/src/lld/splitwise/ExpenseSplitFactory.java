package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class ExpenseSplitFactory {

  private static final Map<ExpenseType, ExpenseSplitStrategy> map = new HashMap<>();

  static {
    map.put(ExpenseType.EXACT, new ExactExpenseSplit());
    map.put(ExpenseType.EQUAL, new EqualExpenseSplit());
    map.put(ExpenseType.PERCENT, new PercentExpenseSplit());
  }

  public static ExpenseSplitStrategy getStrategy(ExpenseType expenseType) {
    return map.get(expenseType);
  }
}
