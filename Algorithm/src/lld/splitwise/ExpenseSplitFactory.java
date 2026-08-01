package lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class ExpenseSplitFactory {

  private static final Map<ExpenseType, IExpense> map = new HashMap<>();

  static {
    map.put(ExpenseType.EXACT, new Exact());
    map.put(ExpenseType.EQUAL, new Equal());
    map.put(ExpenseType.PERCENT, new Percent());
  }

  public static IExpense getStrategy(ExpenseType expenseType) {
    return map.get(expenseType);
  }
}
