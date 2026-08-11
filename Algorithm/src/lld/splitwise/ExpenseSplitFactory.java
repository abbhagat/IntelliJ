package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class ExpenseSplitFactory {

  private static final Map<ExpenseType, IExpense> map = new HashMap<>();

  static {
    map.put(ExpenseType.EXACT, new ExactSplit());
    map.put(ExpenseType.EQUAL, new EqualSplit());
    map.put(ExpenseType.PERCENT, new PercentSplit());
  }

  public static IExpense getStrategy(ExpenseType expenseType) {
    return map.get(expenseType);
  }
}